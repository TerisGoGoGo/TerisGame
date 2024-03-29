package lab14NetGamepackage;
import java.util.Arrays;

/**
 *  四格方块
 *  属性:
 *    --cells ----四个方块 
 *  行为:
 *  	moveLeft()
 *  	moveRight()
 *  	softDrop()
 */
public class Tetromino {
	protected Cell[] cells = new Cell[4];
	/**旋转状态属性，状态个数以数组的形式进行存储*/
	protected State[] states;
	/**定义一个变量：充当旋转次数的计数器*/
	private int count = 100000;
	
	
	/**
	 * 四格方块向左移动
	 * 实际上：就是每个方块向左移动
	 * */
	public void moveLeft() {
		for(int i=0;i<cells.length;i++) {
			Cell cell = cells[i];
			cell.left();
		}
	}
	/**四格方块向右移动*/
	public void moveRight() {
		for(Cell c:cells) {
			c.right();
		}
	}
	/**四格方块向下移动*/
	public void softDrop() {
		for(Cell c:cells) {
			c.drop();
		}
	}
	@Override
	public String toString() {
		return "[" +Arrays.toString(cells) + "]";
	}
	/**随机生成一个四格方块*/
	public static Tetromino randomOne() {
		Tetromino  t = null;
		int num = (int)(Math.random()*7);
		switch(num) {
		case 0:t = new O();break;
		case 1:t = new T();break;
		case 2:t = new I();break;
		case 3:t = new J();break;
		case 4:t = new L();break;
		case 5:t = new S();break;
		case 6:t = new Z();break;
		}
		return t;
	}
	/**
	 * 顺时针，向右旋转四格方块
	 */
	
	public void rotateRight() {
		//旋转有一次，计算器增长1
		count++;//100001
		State s = states[count%states.length];
		//需要获取轴的行号和列号
		Cell c = cells[0];
		int row = c.getRow();
		int col = c.getCol();
		cells[1].setRow(row+s.row1);
		cells[1].setCol(col+s.col1);
		cells[2].setRow(row+s.row2);
		cells[2].setCol(col+s.col2);
		cells[3].setRow(row+s.row3);
		cells[3].setCol(col+s.col3);
		
		
		
	}
	/**
	 * 逆时针，向左旋转四格方块
	 */
	public void rotateLeft() {
		count--;//100001
		State s = states[count%states.length];
		//需要获取轴的行号和列号
		Cell c = cells[0];
		int row = c.getRow();
		int col = c.getCol();
		cells[1].setRow(row+s.row1);
		cells[1].setCol(col+s.col1);
		cells[2].setRow(row+s.row2);
		cells[2].setCol(col+s.col2);
		cells[3].setRow(row+s.row3);
		cells[3].setCol(col+s.col3);
	}
	/**
	 * 定义内部类：State,用于
	 * 封装每次旋转后的相对于轴的其他三个方块的
	 * 坐标(行号，列号)
	 */
	public class State{
		/**
		 * 设计八个属性，分别存储四格方块元素的相对
		 * 位置
		 */
		int row0,col0,row1,col1,row2,col2,row3,col3;
		public State() {}
		public State(int row0, int col0, int row1, int col1, int row2, int col2, int row3, int col3) {
			super();
			this.row0 = row0;
			this.col0 = col0;
			this.row1 = row1;
			this.col1 = col1;
			this.row2 = row2;
			this.col2 = col2;
			this.row3 = row3;
			this.col3 = col3;
		}
		public int getRow0() {
			return row0;
		}
		public void setRow0(int row0) {
			this.row0 = row0;
		}
		public int getCol0() {
			return col0;
		}
		public void setCol0(int col0) {
			this.col0 = col0;
		}
		public int getRow1() {
			return row1;
		}
		public void setRow1(int row1) {
			this.row1 = row1;
		}
		public int getCol1() {
			return col1;
		}
		public void setCol1(int col1) {
			this.col1 = col1;
		}
		public int getRow2() {
			return row2;
		}
		public void setRow2(int row2) {
			this.row2 = row2;
		}
		public int getCol2() {
			return col2;
		}
		public void setCol2(int col2) {
			this.col2 = col2;
		}
		public int getRow3() {
			return row3;
		}
		public void setRow3(int row3) {
			this.row3 = row3;
		}
		public int getCol3() {
			return col3;
		}
		public void setCol3(int col3) {
			this.col3 = col3;
		}
		@Override
		public String toString() {
			return "State [row0=" + row0 + ", col0=" + col0 + ", row1=" + row1 + ", col1=" + col1 + ", row2=" + row2
					+ ", col2=" + col2 + ", row3=" + row3 + ", col3=" + col3 + "]";
		}
		
	
	}
}










