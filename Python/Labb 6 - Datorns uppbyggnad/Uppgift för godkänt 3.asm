main:

li $v0, 5
syscall
move $s0, $v0		#a

li $v0, 5
syscall
move $s1, $v0		#b

li $v0, 5
syscall
move $s2, $v0		#c

add $s3, $s0, $s1
add $s3, $s3, $s2
div $s3, $s3, 2		#s

sub $s0, $s3, $s0	# s-a
sub $s1, $s3, $s1
sub $s2, $s3, $s2

mul $s3, $s3, $s0
mul $s3, $s3, $s1
mul $s3, $s3, $s2

li $v0, 1
move $a0, $s3
syscall