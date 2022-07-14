TITLE Program Assign1
; Assignment 1 question 2
; Julia Garant
; Oct 6 2019

INCLUDE Irvine32.inc

.data
     ;variable declarations
     bigEndian BYTE ?, ?, ?, ?
     littleEndian DWORD ? ;12345678h

     lil BYTE "Value for little endian: ", 0
     

.code
main proc 	
     ;executable intructions
    mov eax,0

    mov edx, OFFSET lil
    call WriteString
     
main endp      
     ;additional procedures
     
end main
