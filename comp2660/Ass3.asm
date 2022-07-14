TITLE Ass3.asm
; Ass3.asm, Assignment 3
; Authors: 
;		Blair Cosgrove (104992533)
;		Sehaj Khaira (104977738)
;		Julia Garant (104987469)
;		Rebecca Wallace (104985434)
; Date: 11/5/2019

INCLUDE Irvine32.inc
INCLUDE Macros.inc

.data
	msg BYTE "What do you want to do now? > ",0
	msg2 BYTE "What is the size N of vector? > ",0
	msg3 BYTE "What are the ",0
	msg4 BYTE " values of Vector? > ",0
	msg5 BYTE "Size of Vector is N = ",0
	s1 BYTE "Stack is empty",0
	s2 BYTE "Stack is not empty",0
	v1a BYTE "Vector is ", 0
	v1aa BYTE "Vector = ", 0
	v1b BYTE "before ArrayToStack",0
	v2a BYTE "Stack is ",0
	v2b BYTE "after ArrayToStack",0
	s1b BYTE "before StackToArray",0
	s2b BYTE "after StackToArray",0
	r1b BYTE "before StackReverse", 0
	r2b BYTE "after StackReverse", 0
	errr BYTE "Error: Stack is empty, cannot perform StackToArray",0
	exitMsg BYTE "I am exiting... Thank you Honey... and Get lost...",0

	Vector DWORD 20 DUP(?)
	N BYTE 0
	sizeN BYTE 0
	stackFlag BYTE 0		;	Flag for if stack is empty (0), or not empty (1)

.code
main PROC
	menu:  
		call crlf
		mov edx, OFFSET msg
		call WriteString
		call readInt		;	Get input from user

		;	MENU LOOP
	     cmp eax, -1
	     je skip				;	exit if user enters -1
		cmp eax, 0
	     je createVec		;	create the Vector if user enters 0
		cmp eax, 1
		je ArrayToStack		;	fill the stack from Vector if user enters 1
		cmp eax, 2
		je StackToArray		;	fill Vector from stack if user enters 2
		cmp eax, 3		
		je StackReverse		;	reverse Vector from stack if user enters 3
		jmp skip

	createVec: 
		;	PRINT MESSAGE AND READ SIZE FROM USER
		call crlf
		mov edx, OFFSET msg2
		call WriteString
		call readInt
		mov N, al
		add sizeN, al				; add N 4 times (DWORD) to sizeN
		add sizeN, al
		add sizeN, al
		add sizeN, al
		mov edx, OFFSET msg3
		call WriteString
		call WriteDec
		mov edx, OFFSET msg4
		call WriteString
	
		;	INPUT VALUES INTO VECTOR USING A LOOP
		mov esi, 0
		movzx ecx, N;
		l1:					
			call readInt			
			mov Vector[esi], eax
			add esi, type Vector
			loop l1

		;	DISPLAY INFO
		mov edx, OFFSET msg5
		call WriteString
		mov al, N
		call WriteDec
		call crlf
		mov edx, OFFSET v1aa
		call writeString

		;	Loop to display the vector that is created.
		mov esi, 0
		movzx ecx, N
		show:
			mov eax, Vector[esi]
			call writeDec
			mWrite " "
			add esi, type Vector
		loop show

		call crlf
		mov edx, OFFSET s1
		call writeString
		call crlf

		jmp menu
;---------------------------------------------------------------------------------------------------------------------
	ArrayToStack: 
		;	Loop to print Vector
		mov edx, OFFSET v1a
		call writeString
		mov esi, 0
		movzx ecx, N
		l2:
			mov eax, Vector[esi]
			call writeDec
			mWrite " "
			add esi, type Vector
			loop l2
		mov edx, OFFSET v1b
		call writeString
		call crlf
		
		;	Loop to push to stack
		mov esi, 0
		movzx ecx, N
		l3:
			mov eax, Vector[esi]
			push eax
			add esi, type Vector
			loop l3
			
		;	loop to pop stack 
		mov edx, OFFSET v2a
		call writeString
		movzx ecx, N
		l4:
			pop eax
			call writeDec
			mWrite " "
			loop l4
		mov edx, OFFSET v2b
		call writeString
		call crlf

		;	loop to push back to stack and clear vector, then print empty Vector
		mov edx, OFFSET v1a
		call writeString
		mov esi, 0
		movzx ecx, N
		l5:
			push Vector[esi]
			mov Vector[esi], 0
			mov eax, Vector[esi]
			call writeDec
			mWrite " "
			add esi, type Vector
			loop l5
		mov edx, OFFSET v2b
		call writeString
		call crlf
		mov edx, OFFSET s2
		call writeString
		call crlf
		mov stackFlag, 1		;	Sets stack flag so that it is not empty (1)
		jmp menu
;---------------------------------------------------------------------------------------------------------------------
	StackToArray:
		cmp stackFlag, 0
		je skip2

		;	Loop to pop stack
		mov edx, OFFSET v2a
		call writeString
		movzx esi, sizeN
		sub esi, type Vector
		movzx ecx, N
		l6:
			pop eax
			call writeDec
			mWrite " "
			mov Vector[esi], eax
			sub esi, type Vector
			loop l6
		mov edx, OFFSET s1b
		call writeString

		call crlf
		mov edx, OFFSET v1a
		call writeString
		mov esi, 0
		movzx ecx, N
		l7: 
			mov eax, Vector[esi]
			call writeDec
			mWrite " "
			add esi, type Vector
			loop l7
		mov edx, OFFSET s2b
		call writeString
		call crlf
		mov edx, OFFSET s1
		call writeString
		call crlf
		mov stackFlag, 0		; just popped stack, set flag to 0 because stack is empty
		jmp menu

		skip2:
			mov edx, OFFSET errr
			call writeString
			call crlf
			jmp menu
;---------------------------------------------------------------------------------------------------------------------
	StackReverse: 
		;set ecx and esi
		mov eax, 0
		movzx ecx, N
		mov esi, 0

		mov edx, OFFSET v1a
		call writeString
		;push on to stack
		L8:	mov eax,Vector[esi]			; get element
			call writeDec
			mWrite " "
			push eax					; push onto stack
			add esi, TYPE Vector
			Loop L8

		mov edx, OFFSET r1b
		call writeString
		call crlf
		mov edx, OFFSET s2
		call writeString
		mov stackFlag, 1			;	Stack is not empty (1)
		call crlf

			;reset ecx and esi
			movzx ecx, N
			mov esi, 0
			
		mov edx, OFFSET v1a
		call writeString
		;pop 
		L9:	pop ebx					; get value from stack
			mov Vector[esi], ebx	; store in array
			mov eax, Vector[esi]
			call writeDec
			mWrite " "
			add esi, TYPE Vector
			Loop L9

		mov edx, OFFSET r2b
		call writeString
		call crlf
		mov edx, OFFSET s1
		call writeString
		mov stackFlag, 0		;	Stack is empty (0)
		call crlf

		jmp menu
;---------------------------------------------------------------------------------------------------------------------	
			skip: 	
				mov edx, OFFSET exitMsg
				call WriteString
		
main ENDP
END main
