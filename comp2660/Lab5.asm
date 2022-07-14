TITLE Program Assign1
; Julia Garant
; Oct 6 2019

INCLUDE Irvine32.inc

.data

.code
main proc 	
     ;executable intructions
     cmp 10, ax     ;ax<10?
     ja next         ;jump to next if ax<10
     cmp 200, bx
     jbe final      ;false
     next: cmp cx,3000
         
     final:
     
main endp      
     ;additional procedures
     
end main
