INCLUDE Irvine32.inc

.data
val3 byte “Hello World”, 0
.code
main PROC
mov EDX, offset val3
callWriteString
callcrlf
call DumpRegs
exit
main ENDP
END main
