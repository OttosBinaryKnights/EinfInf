public class russianCulc {

	public static int farmerExpoRek(int basis, int expo){
		if (expo==0) return 1;
		if (basis==1) return 1;
		if (expo==1) return basis;
		if (expo%2!=0){
			return basis * farmerExpoRek(basis*basis, expo/2);
		} else {
			return farmerExpoRek(basis*basis, expo/2);
		}
	}

	public static int farmerMultRek(int x, int y){
		if (x==0 || y==0) return 0;
		if (x==1) return y;
		if (x%2!=0){
			return y + farmerMultRek(x/2, y*2);
		} else {
			return farmerMultRek(x/2, y*2);
		}
	}

	public static int farmerMultIter(int x, int y){
		int result = 0;
		while(x>0 && y>0){
			if (x%2!=0){
				result=result+y;
			}
			x=x/2;
			y=y*2;
		}
		return result;
	}

	public static void main(String[] args) {
		int a=49;
		for (int i=0;i<50;i++){
			System.out.println(i + "*" + a + " = " + farmerMultIter(i,a) + " " + farmerMultRek(i,a) + " " + i*a);
			a--;
		}
		//System.out.println(farmerMultRek(1,1));
		System.out.println(farmerExpoRek(2,2));
	}

}
