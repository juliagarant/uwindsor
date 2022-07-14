;Assign 2
;Question 1, fibbonaci sequence
;Julia Garant 
;104987469
;Oct 18 2019

include Irvine32.inc
.data
     inputN BYTE "Give a fibbonaci value: ", 0
     N SDWORD ?
     fibStr1 BYTE "Fibonacci sequence with N = ", 0
     
.code
main proc
     mov eax,0
     call clrscr      ;clean

     mov edx, offset inputN   ;get value from user
     call WriteString
     call ReadInt
     mov N, eax

     mov edx, offset fibStr1   ;final sentence output
     call WriteString
     call WriteInt            ;value of N

     call crlf

     mov ebp, 0    
     mov edx, 0
     mov ebx, 1
     mov ecx, N

FibLoop:
       mov eax, edx
       mov ebp, eax
       mov edx, ebx
       add ebx, ebp
       call WriteInt

loop FibLoop
exit	
main endp

end main
