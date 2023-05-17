
import com.sun.nio.sctp.SctpChannel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var list = new ArrayList<User>();

//        var user = new User(1,"株式会社A","AAA",10);
//
//        System.out.println(user.getId());

        list.add(new User("株式会社A","AAA",10));
        list.add(new User("株式会社B","BBB",20));

//        var user = new User("株式会社A","AAA",10);
//        list.add(user);


        System.out.println("--------------------------");
        System.out.println("ユーザー管理システム");
        System.out.println();


        while (true) {

            var sc = new Scanner(System.in);

            System.out.println("メニューを選択してください。");
            System.out.println("1:一覧表示");
            System.out.println("2:新規追加");
            System.out.println("3:削除");
            System.out.println("9:終了");

            var in = sc.nextLine();
            var num = Integer.parseInt(in);

            if (num == 1) {
                System.out.println("--------------------------");
                System.out.println("ユーザー一覧");
                if (list.size() != 0) {
                    for (int i=0; i < list.size(); i++) {
                        System.out.println("|" + list.get(i).getId()
                                + "|" + list.get(i).getCompany()
                                + "|" + list.get(i).getName()
                                + "|" + list.get(i).getScore() + "|");
                    }
                } else {
                    System.out.println();
                    System.out.println("ユーザーが存在しません。");
                }

            } else if (num == 2) {
                System.out.println("--------------------------");
                System.out.println("ユーザー追加");
                System.out.println("所属企業を選択してください");
                System.out.println("1:株式会社A");
                System.out.println("2:株式会社B");

                var company = "";

                while (true) {
                    var select = sc.nextLine();
                    int select_com = 0;
                    try {
                        select_com = Integer.parseInt(select);
                        // エラーが出たら下を実行せずにcatchに飛べる
                        if (select_com == 1) {
                            company = "株式会社A";
                            break;
                        } else if (select_com == 2) {
                            company = "株式会社B";
                            break;
                        } else {
                            System.out.println("数字を選びなおしてください");
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println("数値を入力してください");
                    }
                }

                System.out.println("名前を入力してください");
                String name;
                while (true) {
                    name = sc.nextLine();
                    if (name.equals("") || name.matches("[0-9]+")) {
                        System.out.println("名前を再入力してください");
                    } else {
                        break;
                    }
                }

                System.out.println("スコアを入力してください");
//                score_num = Integer.parseInt(score);
                int score_num = 0;

                while (true) {
                    var score = sc.nextLine();
                    try {
                        score_num = Integer.parseInt(score);
                        if (score_num >= 0 && score_num <= 100) {
                            break;
                        } else {
                            System.out.println("再入力してください。");
                        }
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        System.out.println("数値を入力してください。");
                    }
                }

                list.add(new User(company,name,score_num));

                System.out.println("以下の内容でユーザーが登録されました。");
                //System.out.println(list.get(list.size()).getId());
                System.out.println("id：" + list.size());
                System.out.println("所属企業；" + company);
                System.out.println("名前：" + name);
                System.out.println("スコア：" + score_num);

            } else if (num == 3) {
                System.out.println("--------------------------");
                System.out.println("ユーザー削除");

                int del_id = 0;
//                System.out.println(del_id);
                int deleted_id = 101;

                while (true) {
                    System.out.println("削除するユーザーのIDを選択してください");

                    var select_id = sc.nextLine();
                    del_id = Integer.parseInt(select_id);

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getId() == del_id) {
                            System.out.println("以下のユーザーを削除しました。");
                            System.out.println();
                            System.out.println("id：" + list.get(i).getId());
                            System.out.println("所属企業：" + list.get(i).getCompany());
                            System.out.println("名前：" + list.get(i).getName());
                            System.out.println("スコア" + list.get(i).getScore());
                            deleted_id = i;
                            list.remove(list.get(i));
                        }
                    }

                    if (deleted_id == 101) {
                        System.out.println("無効なIDです。");
                    } else {
                        break;
                    }
                }

            } else if (num == 9) {
                sc.close();
                break;
            }
            System.out.println("--------------------------");
            System.out.println();

        }

    }


}
