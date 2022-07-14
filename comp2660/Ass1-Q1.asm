TITLE Program Assign1
; Assignment 1 question 1 
; Julia Garant
; Oct 6 2019

INCLUDE Irvine32.inc

.data
     ;variable declarations
     A SDWORD -543210
     B SWORD -3210
     G SDWORD ?     ;-43210
     D SBYTE ?      ;-10
     Z SDWORD ?

     valueG BYTE "What is the value of G? ", 0
     valueD BYTE "What is the value of D? ", 0

     zString BYTE "Z=((A-B)-(G-D))", 0

     template BYTE "   ;   ", 0

     tempB SDWORD ?

.code
main proc 	
     ;executable intructions
     mov eax,0      ;clean
     call Clrscr    ;sets cursor to top left

     mov edx, OFFSET valueG   ;entering value for G
     call WriteString
     call ReadInt
     mov G, eax
     call WriteInt
     call Crlf

     mov edx, OFFSET valueD   ;entering value for D
     call WriteString
     call ReadInt
     mov D, al
     call WriteInt
     call Crlf

     mov edx, OFFSET zString   
     call WriteString
     call Crlf
     ;Displays A B G D----------------------------------------------------------------------------
     mov eax, A
     call WriteInt
     mov edx, OFFSET template
     call WriteString

     movsx eax, B
     call WriteInt
     mov edx, OFFSET template
     call WriteString

     mov eax, G
     call WriteInt
     mov edx, OFFSET template
     call WriteString

     movsx eax, D
     call WriteInt
     mov edx, OFFSET template
     call WriteString
     call Crlf

     ;Display Z-------------------------------------------------------
     movsx eax, B
     sub eax, A       ; eax =+540000
     neg eax             ;eax =-540000
     mov tempB, eax
     movsx eax, D
     sub eax, G          ;eax = +43200
     neg eax          ;eax = -43200
     sub eax, tempB      ;eax = +496800
     neg eax        ;eax = -496800
     call Crlf
     call Crlf
     call WriteBin  ;BINARY
     call Crlf
     call WriteInt  ;DECIMAL
     call Crlf
     call WriteHex  ;HEXADECIMAL

main endp      
     ;additional procedures
end main
