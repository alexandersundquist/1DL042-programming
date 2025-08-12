main:

li $v0, 5
syscall
mul $v0, $v0, $v0
move $s0, $v0

li $v0, 5
syscall
mul $v0, $v0, $v0
move $s0, $v0

li $v0, 5
syscall
mul $v0, $v0, $v0
add $s0, $s0, $v0

li $v0, 1
move $a0, $s0 
syscall

