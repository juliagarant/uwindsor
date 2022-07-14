TITLE Program Assign1
; Assignment 1 question 2
; Julia Garant
; Oct 6 2019

INCLUDE Irvine32.inc

.data
     ;variable declarations
     bigEndian BYTE ?, ?, ?, ?
     littleEndian DWORD ?     ;12345678h

     lilEnd BYTE "Value for little endian: ", 0
     
.code
main proc 	
     ;executable intructions
    mov eax,0
    call Clrscr

    mov edx, OFFSET lilEnd
    call WriteString
    call ReadHex
    mov littleEndian, eax        ;littleEndian = 12345678h     bigEndian = 00h, 00h, 00h, 00h
    
    mov eax, [littleEndian+3]
    mov bigEndian, al        ;littleEndian = 12345678h     bigEndian = 00h, 00h, 00h, 12h
    
    mov eax, [littleEndian+2]        
    mov bigEndian, al         ;littleEndian = 12345678h     bigEndian = 00h, 00h, 12h, 34h
    
    mov eax, [littleEndian+1]
    mov bigEndian, al        ;littleEndian = 12345678h     bigEndian = 00h, 12h, 34h, 56h
    
    mov eax, [littleEndian+0]
    mov bigEndian, al        ;littleEndian = 12345678h     bigEndian = 12h, 34h, 56h, 78h

   ; Display bigEndian-------------------------------------------------------
    mov al, bigEndian
    call WriteHex
    call Crlf
     
main endp      
     ;additional procedures
     
end main
