package Schema;

import java.util.Arrays;

public class Contact_book_array {

    final int resized_by = 10;

    int max = 1;
    public int cur = 0;
    public Contact[] DATA;

    public Contact_book_array(Contact new_Contact) {
        DATA = new Contact[max];
        DATA[cur] = new_Contact;
        cur += 1;
    }

    public Contact_book_array() {
        DATA = new Contact[max];
    }

    public Contact_book_array(Contact[] new_Contacts) {

        max = new_Contacts.length;
        cur = max;

        DATA = new Contact[max];

        System.arraycopy(new_Contacts, 0, DATA, 0, max);
    }

    public boolean append(Contact new_Contact) {

        // array full
        if ((cur + 1) == max || max <= (cur + 1)) {
            // System.out.println("[+]array full");
            // System.out.println("[-]array full cur: " + cur);
            // System.out.println("[-]array full max: " + max);

            Contact[] DATA2 = new Contact[DATA.length + resized_by];
            System.arraycopy(DATA, 0, DATA2, 0, DATA.length);
            DATA = null;
            DATA = DATA2;

            DATA[cur] = new_Contact;
            max += resized_by;
            cur += 1;

            // System.out.println("[-]array full cur: " + cur);
            // System.out.println("[-]array full max: " + DATA.length);
            return true;
        }
        // array ok
        else if ((cur + 1) != max && max > (cur + 1)) {
            // System.out.println("[+]array not full");
            DATA[cur] = new_Contact;
            cur += 1;
            return true;
        }
        // other
        else {
            // System.out.println("[+]array other ");
            return false;
        }

    }

    public boolean remove(int index) {

        if (!(index >= 0) && !(index <= max))
            return false;

        Contact[] DATA_part1 = Arrays.copyOfRange(DATA, 0, (index));
        Contact[] DATA_part2 = Arrays.copyOfRange(DATA, (index + 1), (DATA.length));

        Contact[] DATA_temp = new Contact[(DATA.length - 1)];
        max -= 1;
        cur -= 1;

        System.arraycopy(DATA_part1, 0, DATA_temp, 0, DATA_part1.length);
        System.arraycopy(DATA_part2, 0, DATA_temp, ((index - 1) + 1), (DATA_part2.length));

        DATA = DATA_temp;
        return true;
    }

    public boolean removeV2(int index) {

        if (!(index >= 0) && !(index <= max))
            return false;

        Contact[] DATA_temp = new Contact[(DATA.length - 1)];
        max -= 1;
        cur -= 1;

        System.arraycopy(DATA, 0, DATA_temp, 0, index);
        System.arraycopy(DATA, (index + 1), DATA_temp, (index), (DATA_temp.length - index));

        DATA = DATA_temp;
        return true;
    }

    protected Contact[] remove(Contact[] a, int index) {

        Contact[] a_part1 = Arrays.copyOfRange(a, 0, (index));
        Contact[] a_part2 = Arrays.copyOfRange(a, (index + 1), (a.length));

        Contact[] a_temp = new Contact[(a.length - 1)];

        System.arraycopy(a_part1, 0, a_temp, 0, a_part1.length);
        System.arraycopy(a_part2, 0, a_temp, ((index - 1) + 1), (a_part2.length));

        // System.out.println("[+] a_temp >");

        return a_temp;

    }

    public boolean insert(int index, Contact contact) {

        if (!(index >= 0) && !(index <= max))
            return false;

        Contact[] DATA_part1 = Arrays.copyOfRange(DATA, 0, (index));
        Contact[] DATA_part2 = Arrays.copyOfRange(DATA, (index), (DATA.length));
        Contact[] DATA_part3 = { contact };

        Contact[] DATA_temp = new Contact[(DATA.length + 1)];
        max += 1;
        cur += 1;

        System.arraycopy(DATA_part1, 0, DATA_temp, 0, DATA_part1.length);
        System.arraycopy(DATA_part3, 0, DATA_temp, index, 1);
        System.arraycopy(DATA_part2, 0, DATA_temp, ((index - 1) + 2), (DATA_part2.length));

        DATA = DATA_temp;
        return true;
    }

    public boolean insertV2(int index, Contact contact) {

        if (!(index >= 0) && !(index < max))
            return false;

        Contact[] DATA_part3 = { contact };

        Contact[] DATA_temp = new Contact[(DATA.length + 1)];
        max += 1;
        cur += 1;

        System.arraycopy(DATA, 0, DATA_temp, 0, index);
        System.arraycopy(DATA_part3, 0, DATA_temp, (index), 1);
        System.arraycopy(DATA, (index), DATA_temp, (index + 1), (DATA_temp.length - (index + 1)));

        DATA = DATA_temp;
        return true;
    }

    public void popBack() {
        removeV2(cur);
    }

    public int capacity() {
        return this.max;
    }

    public void resize(int capacity) {
        if (cur != capacity && max > capacity) {

            Contact[] DATA_temp = new Contact[capacity];
            System.arraycopy(DATA, 0, DATA_temp, 0, DATA_temp.length);
            DATA = DATA_temp;
        }
    }

    public int[] searchByName(String name) {

        int by = 1;
        int[] ret = new int[0];
        int input = 0;

        for (int i = 0; i != cur; i++) {

            if ((DATA[i].getFirst_name() + " " + DATA[i].getlast_name()).toLowerCase().contains(name.toLowerCase())) {

                if (input == ret.length) {
                    int[] temp = new int[(ret.length + by)];
                    System.arraycopy(ret, 0, temp, 0, ret.length);
                    ret = temp;

                }

                ret[input] = i;
                input++;

            }
        }

        return ret;
    }

    public int[] searchByPhone(String phone) {
        int by = 1;
        int[] ret = new int[0];
        int input = 0;

        for (int i = 0; i != cur; i++) {
            if (DATA[i].getTelephone_number().contains(phone)) {

                if (input == ret.length) {
                    int[] temp = new int[(ret.length + by)];
                    System.arraycopy(ret, 0, temp, 0, ret.length);
                    ret = temp;

                }

                ret[input] = i;
                input++;

            }
        }

        return ret;
    }

    public int[] searchByEmail(String email) {
        int by = 1;
        int[] ret = new int[0];
        int input = 0;

        for (int i = 0; i != cur; i++) {
            if (DATA[i].getEmail().contains(email)) {

                if (input == ret.length) {
                    int[] temp = new int[(ret.length + by)];
                    System.arraycopy(ret, 0, temp, 0, ret.length);
                    ret = temp;

                }

                ret[input] = i;
                input++;

            }
        }

        return ret;
    }
}
