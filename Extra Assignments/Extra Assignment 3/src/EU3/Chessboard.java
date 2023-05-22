package EU3;

public class Chessboard {
    public static class Field {
        private char row;
        private byte column;
        private Chesspiece piece = null;
        private boolean marked = false;

        public Field(char row, byte column) {
            this.row=row;
            this.column=column;
        }

        public void put(Chesspiece piece) {
            this.piece=piece;
        }

        public Chesspiece take() {
            Chesspiece temp = this.piece;
            this.piece = null;
            return temp;
        }

        public void mark() {
            this.marked=true;
        }

        public void unmark() {
            this.marked=false;
        }

        public String toString() {
            String s = (marked) ? " xx" : " --";
            return (piece == null) ? s : piece.toString();
        }
    }

    public static final int NUMBER_OF_ROWS = 8;
    public static final int NUMBER_OF_COLUMNS = 8;
    public static final int FIRST_ROW = 'a';
    public static final int FIRST_COLUMN = 1;
    private Field[][] fields;

    public Chessboard() {
        fields = new Field[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
        char row = 0;
        byte column = 0;
        for (int r = 0; r < NUMBER_OF_ROWS; r++) {
            row = (char) (FIRST_ROW + r);
            column = FIRST_COLUMN;
            for (int c = 0; c < NUMBER_OF_COLUMNS; c++) {
                fields[r][c] = new Field(row, column);
                column++;
            }
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("   1   2   3   4   5   6   7   8\n\n");
        for (int i = 0; i < NUMBER_OF_ROWS; i++) {
            char rowName = (char)(FIRST_ROW + i);
            stringBuilder.append(rowName).append("  ");
            for (int j = 0; j < NUMBER_OF_COLUMNS; j++) {
                stringBuilder.append(fields[i][j].toString()).append("  ");
            }
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString();
    }

    public boolean isValidField(char row, byte column) {
        return row >= 'a' && row <= 'h' && column > 0 && column <= NUMBER_OF_COLUMNS;
    }

    public abstract class Chesspiece
    {
        private char color ;
        // w - white , b - black
        private char name ;
        // K - King , Q - Queen , R - Rook , B - Bishop , N - Knight ,
// P Pawn
        protected char row = 0;
        protected byte column = -1;
        protected Chesspiece ( char color , char name ) {
            this.color=color;
            this.name=name;
        }

        public String toString ()
        {
            return "" + color + name ;
        }

        public boolean isOnBoard ()
        {
            return Chessboard . this . isValidField (row , column );
        }

        public void moveTo ( char row , byte column )
                throws NotValidFieldException
        {
            if (! Chessboard . this . isValidField (row , column ))
                throw new NotValidFieldException
                        ("bad field : " + row + column );
            this . row = row;
            this . column = column ;
            int r = row - FIRST_ROW ;
            int c = column - FIRST_COLUMN ;
            Chessboard . this . fields [r][c]. put ( this );
        }

        public void moveOut () {
            Chessboard.this.fields[row - FIRST_ROW][column - FIRST_COLUMN].take();
        }

        public abstract void markReachableFields ();

        public abstract void unmarkReachableFields ();
    }

    public class Pawn extends Chesspiece
    {
        public Pawn ( char color , char name )
        {
            super (color , name );
        }

        public void markReachableFields ()
        {
            byte col = ( byte ) ( column + 1);
            if ( Chessboard . this . isValidField (row , col ))
            {
                int r = row - FIRST_ROW ;
                int c = col - FIRST_COLUMN ;
                Chessboard . this . fields [r][c]. mark ();
            }
        }
        public void unmarkReachableFields ()
        {
            byte col = ( byte ) ( column + 1);
            if ( Chessboard . this . isValidField (row , col ))
            {
                int r = row - FIRST_ROW ;
                int c = col - FIRST_COLUMN ;
                Chessboard . this . fields [r][c]. unmark ();
            }
        }
    }
    public class Rook extends Chesspiece {
        public Rook ( char color , char name )
        {
            super (color , name );
        }
        public void markReachableFields ()
        {
            for (byte col = 0; col <= 8; col++) {
                if(Chessboard.this.isValidField(row, col) && col != column){
                    int c = col-FIRST_COLUMN;
                    int r = row - FIRST_ROW;
                    Chessboard.this.fields[r][c].mark();
                }
            }
            for (char row1 ='a'; row1 <= 'h'; row1++) {
                if(Chessboard.this.isValidField(row1, column) && row1 != row){
                    int r = row1-FIRST_ROW;
                    int c = column-FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
        }
        public void unmarkReachableFields ()
        {
            for (byte col = 0; col <=8; col++) {
                if(Chessboard.this.isValidField(row, col) && col != column){
                    int c = col-FIRST_COLUMN;
                    int r = row - FIRST_ROW;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
            for (char row1 ='a'; row1 <= 'h'; row1++) {
                if(Chessboard.this.isValidField(row1, column) && row1 != row){
                    int r = row1-FIRST_ROW;
                    int c = column-FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
        }
    }
    public class Knight extends Chesspiece {
        public Knight ( char color , char name )
        {
            super (color , name );
        }
        byte[] mapper = {-1,-2,-2,-1,  1,2,2,1, -1,2,2,-1, 1,-2,-2,1} ;
        //byte[] rowMapper = {-2,-1,1,2};
        /* Alternative solution:
        byte[] mapper ={-1,-2,-2,-1,  1,2,2,1, -1,2,2,-1, 1,-2,-2,1} ;
        for(i=0;i<16;i+=2;)
        char ro=(char)(row +rowMapper[i]);
        byte col=(byte)(column +columnMapper[i]);
        */
        public void markReachableFields ()
        {
            for (char m = 0; row <mapper.length ; row+=2) {
                    if(Chessboard.this.isValidField((char)(row +mapper[m]),
                            (byte)(column + mapper[m+1]))){
                        char row1=(char)(row +mapper[m]-FIRST_ROW);
                        byte col=(byte)(column + mapper[m+1]-FIRST_COLUMN);
                        Chessboard.this.fields[row1][col].mark();
                    }
            }
        }
        public void unmarkReachableFields ()
        {
            for (char m = 0; row <mapper.length ; row+=2) {
                if(Chessboard.this.isValidField((char)(row +mapper[m]),
                        (byte)(column + mapper[m+1]))){
                    char row1=(char)(row +mapper[m]-FIRST_ROW);
                    byte col=(byte)(column + mapper[m+1]-FIRST_COLUMN);
                    Chessboard.this.fields[row1][col].unmark();
                }
            }
        }
    }
    public class Bishop extends Chesspiece {
        public Bishop ( char color , char name )
        {
            super (color , name );
        }
        byte[] mapper={1,1,-1,-1,1};
        public void markReachableFields ()
        {
            for (int i = 0; i <8 ; i++) {
                for (int j = 0; j <4 ; j++) {
                    if(Chessboard.this.isValidField((char)(row+ i*mapper[j]),(byte)(column + i*mapper[j+1]))){
                        char r=(char)(row + i*mapper[j] -FIRST_ROW);
                        byte c=(byte)(column + i*mapper[j+1] -FIRST_COLUMN);
                        Chessboard.this.fields[r][c].mark();
                    }
                }
            }
        }
        public void unmarkReachableFields () {
            for (int i = 0; i <8 ; i++) {
                for (int j = 0; j <4 ; j++) {
                    if(Chessboard.this.isValidField((char)(row+ i*mapper[j]),(byte)(column + i*mapper[j+1]))){
                        char r=(char)(row + i*mapper[j]-FIRST_ROW);
                        byte c=(byte)(column + i*mapper[j+1]-FIRST_COLUMN);
                        Chessboard.this.fields[r][c].unmark();
                    }
                }
            }
        }
    }
    public class Queen extends Chesspiece {
        public Queen ( char color , char name )
        {
            super (color , name );
        }
        byte[] mapper={1,1,-1,-1,1};
        public void markReachableFields ()
        {
            for (byte col = 0; col <=8; col++) {
                if(Chessboard.this.isValidField(row, col) && col != column){
                    int c = col-FIRST_COLUMN;
                    int r = row - FIRST_ROW;
                    Chessboard.this.fields[r][c].mark();
                }
            }
            for (char row1 ='a'; row1 <= 'h'; row1++) {
                if(Chessboard.this.isValidField(row1, column) && row1 != row){
                    int r = row1-FIRST_ROW;
                    int c = column-FIRST_COLUMN;
                    Chessboard.this.fields[r][c].mark();
                }
            }
            for (int i = 0; i <8 ; i++) {
                for (int j = 0; j <4 ; j++) {
                    if(Chessboard.this.isValidField((char)(row+ i*mapper[j]),(byte)(column + i*mapper[j+1]))){
                        char r=(char)((row + i*mapper[j])-FIRST_ROW);
                        byte c=(byte)(column + i*mapper[j+1] -FIRST_COLUMN);
                        Chessboard.this.fields[r][c].mark();
                    }
                }
            }
        }
        public void unmarkReachableFields ()
        {
            for (byte col = 0; col <=8; col++) {
                if(Chessboard.this.isValidField(row, col) && col != column){
                    int c = col-FIRST_COLUMN;
                    int r = row - FIRST_ROW;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
            for (char row1 ='a'; row1 <= 'h'; row1++) {
                if(Chessboard.this.isValidField(row1, column) && row1 != row){
                    int r = row1-FIRST_ROW;
                    int c = column-FIRST_COLUMN;
                    Chessboard.this.fields[r][c].unmark();
                }
            }
            for (int i = 0; i <8 ; i++) {
                for (int j = 0; j <4 ; j++) {
                    if(Chessboard.this.isValidField((char)(row+ i*mapper[j]),(byte)(column + i*mapper[j+1]))){
                        char r=(char)(row + i*mapper[j] -FIRST_ROW);
                        byte c=(byte)(column + i*mapper[j+1] -FIRST_COLUMN);
                        Chessboard.this.fields[r][c].unmark();
                    }
                }
            }
        }
    }
    public class King extends Chesspiece {
        public King ( char color , char name )
        {
            super (color , name );
        }
        byte[] mapper={-1,-1, -1,0, -1,1,  0,-1, 0,1,  1,-1, 1,0, 1,1};
        public void markReachableFields ()
        {
            for (int i = 0; i < mapper.length; i+=2) {
                    if(Chessboard.this.isValidField((char)(row+mapper[i]), (byte)(column+mapper[i+1]))){
                        char r=(char)(row+mapper[i]-FIRST_ROW);
                        byte c=(byte)(column+mapper[i+1]-FIRST_COLUMN);
                        Chessboard.this.fields[r][c].mark();
                    }
            }
        }
        public void unmarkReachableFields ()
        {
            for (int i = 0; i < mapper.length; i+=2) {
                if(Chessboard.this.isValidField((char)(row+mapper[i]), (byte)(column+mapper[i+1]))){
                    char r=(char)(row+mapper[i]-FIRST_ROW);
                    byte c=(byte)(column+mapper[i+1]-FIRST_COLUMN);
                    Chessboard.this.fields[r][c].unmark();
                }
            }
        }
    }
}
