public class User {

    private int rank;
    private int progress;

    public User(){
        rank = -8;
        progress = 0;
    }

    public int getRank(){
        return rank;
    }

    public int getProgress(){
        return progress;
    }

    public void incProgress(int activityRank){
        if(activityRank > 8 || activityRank < -8 || activityRank == 0){
            throw new IllegalArgumentException("The rank of an activity cannot be less than 8, 0, or greater than 8!");
        }
        else {
            int calculatedProgress = calculateProgress(activityRank);
            progress += calculatedProgress;
            while( progress >= 100){
                progress = progress - 100;
                if (rank != -1) {
                    rank += 1;
                } else {
                    rank += 2;
                }
            }

        }
    }

    private int calculateProgress(int activityRank) {
        int difference = this.rank - activityRank;
        int d;

        if ((this.rank < 0 && activityRank > 0) || (this.rank > 0 && activityRank < 0)) {
            d = Math.abs(difference) - 1; // so the difference returns positive
        } else {
            d = difference;
        }

        int calculatedProgress;

        if(this.rank == activityRank){
            calculatedProgress = 3;
        }
        else if (this.rank - 1 == activityRank){
            calculatedProgress = 1;
        }
        else if (this.rank == 1 && activityRank == -1){
            calculatedProgress = 1;
        }
        else {
            calculatedProgress = (d*d*10);
        }
        return calculatedProgress;
    }

    public String toString(){
        return "User{" + "rank=" + rank + ", progress=" + progress + '}';
    }

}