package Algoritms;

import java.util.Scanner;

public class BiletQiymetiHesablama {
	public static void main(String [] args) {
		
	/* İstifadəçidən gediş məsafəsini, yaşını, səyahət tipini
	 alın.Hər km 0.10azn-dən hesablanır.
	 Əgər istifadəçinin yaşı 12 yaşdan aşağıdırsa 50%,
	 12 yaşdan böyük 24 yaşdan balacadırsa 10%,
	 65 yaşdan böyükdürsə 30% edirim olunsun.
	 səyahət növü gediş-gəlişdirsə (yəni 2) o halda
	 yekun məbləğə 20% daha endirim olunsun.*/
		
		
	
	Scanner input=new Scanner(System.in);
	double məsafə=0;
	int yaş=0;
	int səyahətNövü =1;
	
	System.out.print("Məsafəni daxil edin: ");
	məsafə=input.nextDouble();
	System.out.print("Yaşınızı daxil edin: ");
	yaş=input.nextInt();
	System.out.print("Səyahət növünü(1-tək istiqamət,2-gediş/gəliş) daxil edin: ");
	səyahətNövü=input.nextInt();
	

	
	if(məsafə>0 && yaş>0 &&(səyahətNövü==1 || səyahətNövü==2)) {
		
		double biletQiyməti=məsafə*0.10;
		double yaşEndirimMəbləği=0;
		double endirim=0;
		double yolEndirimi=0;
		
		if(yaş<12) {
			
			endirim=0.50;
			
		}else if(yaş>=12 && yaş<=24) {
			
			endirim=0.10;
			
		}else if(yaş>65) {
			
			endirim=0.30;
		}
		 yaşEndirimMəbləği=biletQiyməti*endirim;
		 
		 double endirimliMəbləğ=0;
		 
		 endirimliMəbləğ=biletQiyməti-yaşEndirimMəbləği;
		 
		 if(səyahətNövü==2) {
			 
		endirimliMəbləğ-=endirimliMəbləğ*0.20;
		endirimliMəbləğ*=2;
			 
		 }
		 
		 System.out.println("Yekun məbləğ: "+endirimliMəbləğ+" azn");
		
	}else {
		
		System.err.println("Yanlış məlumat daxil etdiniz !!");
	}
	 
	
    
}
}