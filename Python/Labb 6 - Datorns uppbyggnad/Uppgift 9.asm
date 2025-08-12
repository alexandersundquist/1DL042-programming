main:

la $s5, base 			#adr = base

move $s1, $s5			

loop_input:			#while True:

li $v0, 5			#newnum = int(input("skriv tal:"))
syscall
move $s0, $v0
sw $s0, ($s1)			#Memory.append(newnum)

beq $s0, 0, compare1		#if newnum == 0: break

add $s1, $s1, 4			#adr += 1

j loop_input

compare1:
sub $s1, $s1, 4

compare2:			#while base <= adr:
lw $s2, ($s1)
lw $s3, ($s5)

bne $s3, $s2, not_equal		#if Memory[base] != Memory [adr-1]:

add $s5, $s5, 4			#base += 1
sub $s1, $s1, 4			#adr -= 1

bge $s5, $s1, equal		#while base <= adr:

j compare2


not_equal:			#return 0
li $a0, 0
li $v0, 1
syscall

j end

equal:				#return 1
li $a0, 1
li $v0, 1
syscall

j end

end:
li $v0, 10
syscall















.data
base: .space 40