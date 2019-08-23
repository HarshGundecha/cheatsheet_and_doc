def findMax(h,l,iarr):
	mx = ((int)((h+l)/2))+1
	while( l < h ):
		m = (int)((h+l)/2)
		if( m+1 < len(iarr) ):
			#print("yes111")

			if( iarr[m] > iarr[mx] ):
				# print("yes222")
				if( iarr[m+1] < iarr[m] ):
					h = m
					mx = m
				else:#iarr[m+1] > m
					l = m+1
					mx = m+1

			elif( iarr[m] < iarr[mx] ):
				if( iarr[m+1] < iarr[m] ):
					h = m-1
				else:#iarr[m+1] > m
					l = m+1
					if( iarr[m+1] > iarr[mx] ):
						mx = m+1

			elif( iarr[m] == iarr[mx] ):
				if( iarr[m+1] < iarr[m] ):
					h = m
				else:#iarr[m+1] > m
					l = m+1
					mx = m+1
				break

			else:
				break
		else:
			#print("just something : ",iarr[m])
			break
	return mx

t = (int)(input())
while(t > 0):
	input()
	iarr=list(map(int,input().split()))
	#for(mx = -1, h = iarr.length-1, l = 0, m = (h+l)/2 l<highmid = (h+l)/2):
	mx = findMax(len(iarr)-1, 0, iarr)

	if( mx > 0 and mx < len(iarr)-1 ):
		while( iarr[mx+1] > iarr[mx] ):
			mx = mx+1
		while( iarr[mx-1] > iarr[mx] ):
			mx = mx-1
	elif( mx == 0 ):
		if iarr[len(iarr)-1] > iarr[mx]:
			mx = len(iarr)-1
			while( iarr[mx-1] > iarr[mx] ):
				mx = mx-1
		# temp = findMax( len(iarr)-1, (int)(len(iarr)/2), iarr)
		# print(temp)
		# mx = (mx,temp)[ iarr[temp] > iarr[mx] ]
	elif( mx == len(iarr)-1 ):
		if iarr[0] > iarr[mx]:
			mx = 0
			while( iarr[mx+1] > iarr[mx] ):
				mx = mx+1
		# temp = findMax( (int)(len(iarr)/2), 0, iarr)
		# mx = (mx,temp)[ iarr[temp] > iarr[mx] ]
	# print(mx)
	# print(len(iarr)-1)
	# type1 = ( (3, 2)[mx==0], (4, 1)[len(iarr)-1==mx] )[ iarr[0] < iarr[1] and iarr[1] < iarr[2]]


	if (iarr[0]<iarr[1]) == (iarr[len(iarr)-2]<iarr[len(iarr)-1]):
		type1 = (2, 1)[iarr[0] < iarr[1]]
	else:
		if mx==0:
			type1 = (2, 1)[iarr[len(iarr)-2] < iarr[len(iarr)-1]]
			
		else:
			type1 = (2, 1)[iarr[0] < iarr[1]]
	type2 = (type1, 5-type1)[mx not in (0, len(iarr)-1)]
	print(iarr[mx],type2)
	t=t-1;