main:

la $s5, base 

move $s1, $s5

add $s6, $s5, 40

loop_input:

beq $s1, $s6, loop_print

li $v0, 5
syscall
move $s0, $v0
sw $s0, ($s1)

beq $s0, 0, loop_print

add $s1, $s1, 4

j loop_input

loop_print:

sub $s1, $s1, 4

loop_print2:

lw $s2, ($s1)

li $v0, 1	
move $a0, $s2
syscall

beq $s1, $s5, end

sub $s1, $s1, 4

j loop_print2

end:
li $v0, 10
syscall

.data
base: .space 40
