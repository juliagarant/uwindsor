;Assign 2
;Question 2
;Julia Garant 
;104987469
;Oct 18 2019

include Irvine32.inc
.data
     prompt BYTE "Enter a string of at most 128 characters: ",0
     MAX = 128
     input BYTE MAX+1 DUP(?)            ;user input
     target BYTE MAX+1 DUP(?)			;reversed array
	userInput DWORD ?				;size of input array
     upperCount DWORD 0                 ;amount of upper letters after conversion
;strings
     output BYTE "Here it is, with all lowercases and uppercases flipped, and in reverse order: ",0
     thereAre BYTE "There are ",0
     numChar BYTE " characters in the string.",0
     numUpper BYTE " upper case letters after conversion.",0
.code
main proc
     mov eax,0        ;clean          
     call clrscr      ;clean

     mov edx, OFFSET prompt  
     call WriteString
     mov edx, OFFSET input     ;1) get input from user
     mov ecx, MAX              ;2) buffer size - 1
     call ReadString           ;3) read string
	MOV userInput, eax		 ;4) get input length
     call crlf
;--------CHAR IN STRING-------------------------------------------------------------------------------------
     mov edx, OFFSET thereAre  
     call WriteString
     mov ebx, userInput       ;get num of char in string
     call WriteInt
     mov edx, OFFSET numChar  
     call WriteString
     call crlf
;-------CONVERT STRING--------------------------------------------------------------------------------------
     mov ecx, 0
     mov edx, OFFSET thereAre       ;OUTPUT
     call WriteString               ;OUTPUT
     L1: cmp userInput,ecx 
         JL endWhile               ;jump if userInput<ecx (values)

         ifUpper: cmp input[ecx], 41h
                  JB ifLower              ;jump if input[ecx] < 41h
                  cmp input[ecx], 5Ah
                  JA ifLower              ;jump if input[ecx] > 5Ah
                  ADD input[ecx], 20h
                  INC ecx                 ;move to next element
                  JMP L1
         ifLower: cmp input[ecx], 61h
                  JB notUL              ;jump if input[ecx] < 61h
                  cmp input[ecx], 7Ah
                  JA endWhile              ;jump if input[ecx] > 7Ah
                  SUB input[ecx], 20h
                  INC upperCount
                  INC ecx                 ;move to next element
                  JMP L1
         notUL:   INC ecx
                  JMP L1
    loop L1                                                      
     endWhile: 
               mov eax, upperCount
               call WriteInt
               mov edx, OFFSET numUpper  
               call WriteString
               call crlf
               call crlf
 
;-------REVERSE STRING--------------------------------------------------------------------------------------
mov edx, OFFSET output             ;OUTPUT
call WriteString                   ;OUTPUT
call crlf                          ;OUTPUT

	mov ecx, userInput              ;last position of input string
	mov esi, 0				  ;beginning of reversed string
	L2:
		MOV al, input[ecx - 1]        ;accounting for the null character
		MOV target[esi], al           ;swap
	     inc esi                       ;move to next position
	loop L2

	mov edx, OFFSET target       ;OUTPUT
	call WriteString             ;OUTPUT
     call crlf                    ;OUTPUT
main endp

end main
