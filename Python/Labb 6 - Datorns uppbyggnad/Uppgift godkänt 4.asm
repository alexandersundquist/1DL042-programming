main:

li $v0, 5
syscall
move $s0, $v0			#first_number = input()

li $v0, 5
syscall
move $s1, $v0			#second_number = input()

li $v0, 5
syscall
move $s2, $v0			#third_number = input()

bgt $s0, $s1, firstgreater	#if first_number > second_number:

bgt $s1, $s2, printsecond	#elif second_number > third_number:

j printthird


printsecond:			#print (second_number)
li $v0, 1
move $a0, $s1
syscall

j end

printthird:			#print (third_number)
li $v0, 1
move $a0, $s2
syscall

j end

firstgreater:			#if first_number > third_number:
bgt $s0,$s2, printfirst

j printthird			#Vet att $s2 är större än $s0 som är större än $s1 ifall den kommit hit

printfirst:			#print(first_number)
li $v0, 1
move $a0, $s0
syscall

end:
li $v0, 10
syscall 