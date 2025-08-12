main:

# $s1 kan ses som highest 

li $v0, 5		#tal = input()
syscall
move $s0, $v0

beq $s0, 0, end		#if tal==0: break

bgt $s0, $s1, replace	#if tal>highest:

j main

replace:		#highest=tal
move $s1, $s0

j main

end:			
li $v0, 1		#print highest
move $a0, $s1
syscall

li $v0, 10
syscall