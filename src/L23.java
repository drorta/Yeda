import java.util.Arrays;

public class L23 extends HelpCommands {

    public static int amount(Committee[] committees, Member member){
        int amount = 0;
        for (Committee committee : committees){
            if (member.isCoal()) {
                int coals = committee.total(true) + 1;
                if (coals > committee.total(false) && committee.getCount()+1 < 16) {
                    amount++;
                }
            } else {
                int notCoals = committee.total(false) + 1;
                if (notCoals < committee.total(true) && committee.getCount()+1 < 16) {
                    amount++;
                }
            }
        }
        return amount;
    }

    public static void main(String[] args) {
//        Weight weight = new Weight(1, 1);
//        Weight weight1 = new Weight(10010);
//        System.out.println(weight);
//        System.out.println(weight1);
//        weight.add(weight1);
//        System.out.println(weight);
//        System.out.println(weight.less(weight1));

//        AllWeights allWeights = new AllWeights(Weight.generateArray(5, 5000) );
//        System.out.println(Arrays.toString(allWeights.getWeights()));
//        System.out.println(allWeights.sum());

        Committee committee = new Committee("uno",
                new Member[]{new Member("uno", true),
                        new Member("dos", false)
                },
                2
        );
        Committee committee1 = new Committee("dos",
                new Member[]{
                        new Member("uno", true),
                        new Member("dos", true)
                },
                2
        );
        Committee committee2 = new Committee("tres",
                new Member[]{
                        new Member("uno", true)
                },
                15
        );
        Committee[] committees = new Committee[]{committee, committee1, committee2};
        System.out.println(amount(committees, new Member("mem", false)));

    }

}
