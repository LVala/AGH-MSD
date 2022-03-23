public class Point {

    public static Integer[] types = {0, 1, 2, 3, 5};
    public int type = 0;
    public int speed = 0;
    public Point next;
    public Point prev;
    public Point left;
    public Point right;
    public boolean moved = false;
    

    public void move() {
        Point curNext = this;
        Point curPrev = this;
        Point other = left == null ? this.right : this.left;
        int d_prev = 0;
        int d_next = 0;  // jak dodajesz pojazd, to niech ma predkosc max
        int d_other_prev = 0;
        int d_other_next = 0;

        //  calculation free space
        for (int i = 0; i <= 8; ++i) {
            if (curNext.next.type != 0 && curNext.next.type != 5) {
                d_next = i;
                break;
            }
        }
        for (int i = 0; i <= 8; ++i) {
            if (curPrev.prev.type != 0 && curPrev.prev.type != 5) {
                d_prev = i;
                break;
            }
            curPrev = curPrev.next;
        }
        






        if (right == null) {  // manewr wyprzedzania
            for (int i = 0; i <= speed; ++i) {
                if (curNext.prev.type == 0 || curNext.next.type == 5) {
                    d_next = i;
                    break;
                }
            }
            for (int i = 0; i <= speed; ++i) {
                if (curNext.next.type == 0 || curNext.next.type == 5) {
                    d_next = i;
                    break;
                }
            }
            curNext = curNext.next;
        }


        if (type == 1 && moved == false) {
            // acceleration
            speed = (speed < 5) ? ++speed : speed;

            // slowing down
            for (int i = 0; i <= speed; ++i) {
                if (curNext.next.type == 1 || i == speed) {
                    speed = i;
                    break;
                }
                curNext = curNext.next;
            }

            // actual moving
            type = 0;
            curNext.type = 1;
            curNext.speed = speed;
            moved = true;
            curNext.moved = true;
        }
    }

    public int getMaxSpeed() {
        if (type != 0 && type != 5)
            return type*2 + 1;
        else return 0;
    }

    public void clicked() {
        type = 1;
    }

    public void clear() {
        type = 0;
    }
}