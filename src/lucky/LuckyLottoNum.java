package lucky;

import entity.NumEntity;

import java.io.*;
import java.util.*;
 
public class LuckyLottoNum {
 
	private static BufferedReader br;

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<NumEntity> numbers = getCreateNumbers();
		int[] values = new int[7] ;
		int i = 0;
 
		Collections.sort(numbers, new NoDescCompare());
		for (NumEntity temp : numbers) {
			if(i < 5){
				values[i] = temp.getNum1();
			}else if(i == 5){
				values[i] = temp.getNum1();
			}else if(i == 6){
				values[i] = temp.getNum1();
				break;
			}
			i++;
		}
		
		Arrays.sort(values);
		System.out.println("------------------------------로또번호-----------------------------");
		System.out.print("이번주 로또 번호는 : ");
		int k = 0;
		for(int value : values){
			System.out.print(value);
			if(k < 6)
			System.out.print(",");
			k++;
		}
		System.out.print(" 입니다. 짝짝짝 일등하세요!!!!");
 
//		Collections.sort(numbers, new NoDescCompare());
//		System.out.printf("\n\n===== 숫자 내림 차순 정렬 =====\n");
//		for (NumEntity temp : numbers) {
//			i++;
//			if(i == 6){
//				break;
//			}
//		}
	}
	
	private static List<NumEntity> getCreateNumbers() throws IOException {
		List numbers = new ArrayList<NumEntity>();
		List<String> list = null;
		String allLottoList = "";
		File file = new File("../luckyLotto/list/lottoList.txt");
		try {
			FileReader fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line = "";
			while((line = br.readLine()) != null){
				allLottoList += line.trim() + ",";
			}
			allLottoList = allLottoList.substring(0, allLottoList.length() - 1);
			list = new ArrayList<>(Arrays.asList(allLottoList.split(",")));


		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 int[] count = new int[46];
		 NumEntity numEntity = new NumEntity();
		 // 해당 숫자 갯수
		 
		 
		 for(String i : list) {	//배열갯수만큼돌면서
			 //	현재 인덱스의 숫자를 저장
			 count[Integer.parseInt(i)]++;
		 }
		  
		  for(int i=1;i < count.length;i++){
			  numEntity = new NumEntity();
			  numEntity.setNum1(i);
			  numEntity.setNum2(count[i]);
			  numbers.add(numEntity);
		  }
		
		return numbers;
	}
  
//	 /**
//	  * 이름 오름차순
//	  * @author falbb
//	  *
//	  */
//	static class NameAscCompare implements Comparator<NumEntity> {
// 
//		/**
//		 * 오름차순(ASC)
//		 */
//		@Override
//		public int compare(NumEntity arg0, NumEntity arg1) {
//			// TODO Auto-generated method stub
//			return arg0.getName().compareTo(arg1.getName());
//		}
// 
//	}
// 
//	/**
//	 * 이름 내림차순
//	 * @author falbb
//	 *
//	 */
//	static class NameDescCompare implements Comparator<User> {
// 
//		/**
//		 * 내림차순(DESC)
//		 */
//		@Override
//		public int compare(User arg0, User arg1) {
//			// TODO Auto-generated method stub
//			return arg1.getName().compareTo(arg0.getName());
//		}
// 
//	}
 
	 /**
	  * No 오름차순
	  * @author falbb
	  *
	  */
	static class NoAscCompare implements Comparator<NumEntity> {
 
		/**
		 * 오름차순(ASC)
		 */
		@Override
		public int compare(NumEntity arg0, NumEntity arg1) {
			// TODO Auto-generated method stub
			return arg0.getNum2() < arg1.getNum2() ? -1 : arg0.getNum2() > arg1.getNum2() ? 1:0;
		}
 
	}
 
	/**
	 * No 내림차순
	 * @author falbb
	 *
	 */
	static class NoDescCompare implements Comparator<NumEntity> {
 
		/**
		 * 내림차순(DESC)
		 */
		@Override
		public int compare(NumEntity arg0, NumEntity arg1) {
			// TODO Auto-generated method stub
			return arg0.getNum2() > arg1.getNum2() ? -1 : arg0.getNum2() < arg1.getNum2() ? 1:0;
		}
 
	}
 
 
}