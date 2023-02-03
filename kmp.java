class kmp{
	 static void  fillips(String str,int lps[]){
                int n=str.length();
                int len=0;
                int i=1;
                lps[0]=0;
                while(i<n){
                        if(str.charAt(i)==str.charAt(len)){
                                len++;
                                lps[i]=len;
                                i++;

                        }else{
                                if(len==0){
                                        lps[i]=0;
                                        i++;
                                }else{
                                        len=lps[len-1];
                                }
                        }
//			System.out.println(lps[i]);
                }
		for(int j=0;j<lps.length;j++){
			System.out.print(lps[j]+" ");
		}
        }

	static String kmp(String str,String pat){
		int n=str.length();
		int m=pat.length();
		int lps[]=new int[m];
		fillips(pat,lps);
		int i=0;
		int j=0;
		while(i<n && j<m){
			if(str.charAt(i)==pat.charAt(j)){
				i++;
				j++;
				if(j==m){
					//System.out.println(i-j);
					 j=lps[j-1];
					return str;
				/*	for(int k=0;k<lps.length;k++){
						System.out.println(lps[k]+" ");
					}
					System.out.println(j);
					break;*/

				//	j=lps[j-1];
				}
			}else if(i<n && str.charAt(i)!=pat.charAt(j)){
				if(j==0){i++;}
				else{
					j=lps[j-1];
				}
			}
		}
		return null;
	}
	public static void main(String  [] args){
		String s="ababac";
		String pat="aba";
		int lps[]=new int[s.length()];
	//	System.out.println(kmp(s,pat));
		fillips(s,lps);
	}

}
