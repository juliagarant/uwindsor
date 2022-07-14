TITLE Ass4.asm
; Ass4.asm, Assignment 4
; Authors: 
;	Julia Garant (104987469)
;	Rebecca Wallace (104985434)
; Date: 11/18/2019
INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
     msg BYTE "What do you want to do, Lovely? ( W or R ) ", 0
     value1 BYTE "Enter a decimal number to be converted:", 0
     value2 BYTE "Enter a hexadecimal number to be converted:", 0
     h BYTE "h", 0 
	exit1 BYTE "Thank you, Sweetey Honey Bun ", 0
	exit2 BYTE "Get Lost, you Sweetey Honey Bun ", 0

     charIn BYTE ?
     userHex DWORD ?

.code
main proc
     mov eax, 0          ;clean 
     mov ebx, 0          ;clean
     call clrscr         ;clean
	call crlf        ;new line

	mov edx, OFFSET msg      ;prompt
	call WriteString
     call ReadChar       ;get user input
     mov charIn, al
     movzx ebx, charIn
     call WriteChar

     cmp ebx,'w'         ;responds to w W for HexOutput
     je HexOutput
     cmp ebx,'W'
     je HexOutput
     cmp ebx,'r'         ;responds to r R for HexInput
     je HexInput
     cmp ebx,'R'
     je HexInput
     call crlf        ;new line
	mov edx, OFFSET exit2         ;Exits with "exit2" if anything else is pressed
	call WriteString
     jmp endMain
;---------------------------------------------------------------------------------------
     HexOutput:
          call crlf        ;new line
          mov edx, OFFSET value1      ;prompt
	     call WriteString
          call ReadDec
          call WriteHexB
          mov edx, OFFSET h      ;h 
	     call WriteString

          call crlf        ;new line
          mov edx, OFFSET exit1         ;exit message and exits
	     call WriteString
     jmp endMain
;---------------------------------------------------------------------------------------
     HexInput:
          call crlf        ;new line
          mov edx, OFFSET value2      ;prompt
	     call WriteString
;Attempt of converting each individual character into binary-------------------------------------
COMMENT @
          mov esi, 0
          l1:
               cmp al,'h'          ;if char = h exit
               je print
               cmp esi, 9          ;if 8 bits(plus possible h) exit
               je print
               call ReadChar       ;read input
               mov charIn, al      ;move into charIn
               call WriteChar      ;output it

          nums:cmp charIn, 30h
               jb letters
               cmp charIn, 39h
               ja letters
               call crlf        ;new line
               mov charIn, al 
               call WriteBinB
               call crlf        ;new line
               jmp next

       letters:cmp charIn,'h'
               jmp print

               cmp charIn, 'f'
               call crlf        ;new line
               mov al, charIn 
               call WriteBinB
               call crlf        ;new line
               
               jmp next

         next: inc esi        ;loop counter
               loop l1
               @

          call ReadHex
          mov userHex, eax
          call WriteBin

;print:
          call crlf        ;new line
          mov edx, OFFSET exit1         ;exit message and exits
	     call WriteString
     jmp endMain
;---------------------------------------------------------------------------------------
     endMain:
main endp
end main
