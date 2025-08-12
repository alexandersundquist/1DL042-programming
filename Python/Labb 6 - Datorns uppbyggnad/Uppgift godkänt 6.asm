main:

# $s1 sum 
# $s2 antal
#$s3 sum/antal

li $v0, 5		#n = input()
syscall
move $s0, $v0

beq $s0, 0, end		#if n==0: break

add $s1, $s1, $s0	#sum += n

add $s2, $s2, 1		#antal += 1

j main

end:
div $s3, $s1, $s2	#sum/antal

li $v0, 1		#print print sum/antal
move $a0, $s3
syscall

li $v0, 10
syscall