import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[]args){
        launch(args);
    }
    public void start(Stage primaryStage){
        final int[] score = {1000000,0};
        final int[] add = {1,1};
        final int[] prix = {10,10,10,1000000,50};
        final int[] condition = {10,0};
        final boolean[] etape2 = {false};
        final int[] remise = {0};

        primaryStage.setWidth(800);
        primaryStage.setHeight(800);
        primaryStage.setTitle("Clique !");
        primaryStage.setResizable(false);

        Button principal = new Button("Obtenir des points !");
        Button ameliorer1 = new Button("+1 Point/clique(prix : "+prix[0]+")");
        Button ameliorer2 = new Button("Reduire le coût (prix : "+prix[1]+")");
        Button ameliorer3 = new Button("Débloquer 10 améliorations (prix : "+prix[2]+")");
        Button ameliorer4 = new Button("Débloquer l'Or!(prix : "+prix[3]+")");
        Button ameliorer5 = new Button("Remise d'achat(prix : "+prix[4]+")");
        Button Or = new Button("Obtenir de l'or !");
        Label points = new Label("Points : " + score[0]);
        Label or = new Label("");
        Label amelioration = new Label("points d'amélioration: " + (condition[0]-condition[1]));

        ameliorer5.setOnAction(event -> {
            if(condition[0]>condition[1]){
                if(50>=remise[0]){
                    if(score[0]>=prix[4]){
                        score[0] = score[0]-prix[4];
                        remise[0]= remise[0]+5;
                        prix[4] = (prix[4]+100)*2;
                        condition[1]++;
                    }
                }
            }

            points.setText("points : " + score[0]);
            ameliorer5.setText("Remise d'achat(prix : "+prix[4]+")");
            amelioration.setText("points d'amélioration: " + (condition[0]-condition[1]));
        });
        ameliorer5.setTranslateX(350);
        ameliorer5.setTranslateY(290);

        ameliorer4.setOnAction(event -> {
            if (score[0]>=prix[3]){
                score[0] = score[0]-prix[3];
                score[0] = score[0] + ((prix[3]*remise[0])/100);
                etape2[0] = true;
                or.setText("Or : " + score[1]);
                points.setText("points : " + score[0]);
                Or.setTranslateY(470);

            }
        });
        ameliorer4.setTranslateX(350);
        ameliorer4.setTranslateY(320);

        Or.setOnAction(event ->  {
            if(etape2[0]){
                score[1] = score[1]+ add[1];
                or.setText("Or : " + score[1]);
            }
        });
        Or.setTranslateX(350);
        Or.setTranslateY(-500);
        Or.setScaleX(4);
        Or.setScaleY(4);

        ameliorer3.setOnAction(event -> {
            if (score[0]>=prix[2]){
                score[0] = score[0] - prix[2];
                score[0] = score[0] + ((prix[2]*remise[0])/100);
                prix[2]=prix[2]*3;
                condition[0] = condition[0]+10;

            }
            amelioration.setText("points d'amélioration: " + (condition[0]-condition[1]));
            ameliorer3.setText("Débloquer 10 améliorations (prix : "+prix[2]+")");
        });
        ameliorer3.setTranslateX(350);
        ameliorer3.setTranslateY(260);


        ameliorer2.setOnAction(event -> {
            if(condition[0]>condition[1]){
                if (score[0]>=prix[1]){
                    score[0] = score[0] - prix[1];
                    score[0] = score[0] + ((prix[1]*remise[0])/100);
                    prix[1]=prix[1]*2;
                    prix[0]=prix[0]/2;
                    condition[1]++;

                }
            }
            points.setText("points : " + score[0]);
            ameliorer1.setText("+1 Point/clique(prix : "+prix[0]+")");
            ameliorer2.setText("Reduire le coût (prix : "+prix[1]+")");
            amelioration.setText("points d'amélioration: " + (condition[0]-condition[1]));
        });
        ameliorer2.setTranslateX(350);
        ameliorer2.setTranslateY(230);

        ameliorer1.setOnAction((event -> {
            if(condition[0]>condition[1]){
                if(score[0]>=prix[0]) {
                    score[0] = score[0] - prix[0];
                    score[0] = score[0] + ((prix[0]*remise[0])/100);
                    add[0] = add[0]+1;
                    prix[0]=prix[0]+10;
                    condition[1]++;
                }
            }
            points.setText("points : " + score[0]);
            ameliorer1.setText("+1 Point/clique(prix : "+prix[0]+")");
            amelioration.setText("points d'amélioration: " + (condition[0]-condition[1]));
        }));
        ameliorer1.setTranslateX(350);
        ameliorer1.setTranslateY(200);

        principal.setScaleX(4);
        principal.setScaleY(4);
        principal.setTranslateX(350);
        principal.setTranslateY(600);
        principal.setOnAction((event)->{
            score[0] = score[0]+ add[0];
            points.setText("points : " + score[0]);
        });

        points.setTranslateX(350);
        points.setTranslateY(50);
        points.setScaleX(3);
        points.setScaleY(3);

        or.setTranslateX(350);
        or.setTranslateY(100);
        or.setScaleX(3);
        or.setScaleY(3);

        amelioration.setTranslateX(350);
        amelioration.setTranslateY(130);

        Group groupe1 = new Group(principal,points,ameliorer1,ameliorer2,ameliorer3,amelioration,ameliorer4,Or,or,ameliorer5);

        primaryStage.setScene(
                new Scene(groupe1)
        );
        primaryStage.show();

    }
}
