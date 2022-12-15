package com.bounce.game.States;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.bounce.game.Controls.Button;
import com.bounce.game.Controls.Collisions;
import com.bounce.game.GameObjects.Ball;
import com.bounce.game.GameObjects.Ring;
import com.bounce.game.GameObjects.Snowflake;
import com.bounce.game.Levels.Loader;

import java.util.ArrayList;

public class GameState extends State {

    private final Ball ball;
    private final Collisions collisions;
    private final Button left, right, up, pause;
    private final Texture ring;
    private final ArrayList<Texture> numbers;
    private final com.bounce.game.Controls.Texture life, X;
    private int state;
    private final Button resume, again, menu;
    private final com.bounce.game.Controls.Texture background;

    public GameState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 1080, 540);
        camera.zoom = 0.815f;
        camera.position.set(Math.min(Math.max(Loader.ballPosition.x, camera.viewportWidth / 2 * camera.zoom), Loader.map.length * Loader.size - camera.viewportWidth / 2 * camera.zoom),
                Math.min(Math.max(Loader.ballPosition.y, camera.viewportHeight / 2 * camera.zoom), Loader.map[0].length * Loader.size - camera.viewportHeight / 2 * camera.zoom), 0);
        ball = new Ball("ball_54x54.png", "ball_81x81.png", Loader.ballPosition.x, Loader.ballPosition.y, 27);
        collisions = new Collisions();
        left = new Button(40 / camera.zoom, 30 / camera.zoom, 82, 82, "Left.png");
        right = new Button(145 / camera.zoom, 30 / camera.zoom, 82, 82, "Right.png");
        up = new Button(925 * camera.zoom, 30 / camera.zoom, 82, 82, "Up.png");
        pause = new Button(1020 * camera.zoom, 483 * camera.zoom, 35, 35, "Pause.png");
        life = new com.bounce.game.Controls.Texture(112, 442, 35, 35, "ball_chet.png");
        X = new com.bounce.game.Controls.Texture(150, 440, 30, 35, "X.png");
        numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(new Texture("num_" + i + ".png"));
            numbers.get(i).setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        }
        ring = new Texture("ring_for_count.png");
        ring.setFilter(com.badlogic.gdx.graphics.Texture.TextureFilter.Linear, com.badlogic.gdx.graphics.Texture.TextureFilter.Linear);
        state = 1;
        background = new com.bounce.game.Controls.Texture(100, 50, 880, 440, "background_pause.png");
        resume = new Button(310, 270, 259, 73, "resume_button.png");
        again = new Button(310, 170, 259, 73, "restart_button.png");
        menu = new Button(310, 70, 259, 73, "menu_button_pause.png");
    }

    @Override
    protected void handleInput() {
        if (state == 1) {
            Vector3 touch1 = new Vector3(0, 0, 0);
            Vector3 touch2 = new Vector3(0, 0, 0);
            if (Gdx.input.isTouched(0)) {
                touch1 = new Vector3(Gdx.input.getX(0), Gdx.input.getY(0), 0);
                camera.unproject(touch1);
            }
            if (Gdx.input.isTouched(1)) {
                touch2 = new Vector3(Gdx.input.getX(1), Gdx.input.getY(1), 0);
                camera.unproject(touch2);
            }
            if (left.getRectangle().contains(touch1.x, touch1.y) || left.getRectangle().contains(touch2.x, touch2.y))
                ball.moveLeft();
            if (right.getRectangle().contains(touch1.x, touch1.y) || right.getRectangle().contains(touch2.x, touch2.y))
                ball.moveRight();
            if (up.getRectangle().contains(touch1.x, touch1.y) || up.getRectangle().contains(touch2.x, touch2.y))
                ball.jump();
            if (pause.isClick(tempDown, tempUp)) state = 2;
        } else {
            if (resume.isClick(tempDown, tempUp)) state = 1;
            if (again.isClick(tempDown, tempUp)) {
                Loader.loadLevel();
                gsm.set(new GameState(gsm));
            }
            if (menu.isClick(tempDown, tempUp)) {
                gsm.set(new SelectLevel(gsm));
            }
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        if (state == 1) {
            for (Snowflake snowflake : Loader.snowflakes) {
                snowflake.update(dt);
            }
            ball.update(dt);
            collisions.checkingCollision(ball, dt, gsm);
            float offsetX = Math.max(Math.min((camera.viewportWidth / 3) / Math.abs(ball.getCircle().x - camera.position.x), 4), 2f) * (ball.getCircle().x - camera.position.x) * dt;
            float offsetY = Math.max(Math.min((camera.viewportHeight / 3) / Math.abs(ball.getCircle().y - camera.position.y), 4), 2f) * (ball.getCircle().y - camera.position.y) * dt;
            camera.translate(offsetX, offsetY);
            camera.position.set(Math.min(Math.max(camera.position.x, camera.viewportWidth / 2 * camera.zoom), Loader.map.length * Loader.size - camera.viewportWidth / 2 * camera.zoom),
                    Math.min(Math.max(camera.position.y, camera.viewportHeight / 2 * camera.zoom), Loader.map[0].length * Loader.size - camera.viewportHeight / 2 * camera.zoom), 0);
            left.update(camera);
            right.update(camera);
            up.update(camera);
            pause.update(camera);
        } else {
            resume.update(camera);
            again.update(camera);
            menu.update(camera);
        }
    }

    @Override
    public void render(SpriteBatch sb) {
        camera.update();
        sb.setProjectionMatrix(camera.combined);
        sb.begin();
        if (state == 1) {
            int begin_i = Math.min(Math.max((int) (camera.position.x - camera.viewportWidth / 2) / 55, 0), Loader.map.length - 1);
            int end_i = Math.max(Math.min((int) (camera.position.x + camera.viewportWidth / 2) / 55, Loader.map.length - 1), 0);
            int begin_j = Math.min(Math.max((int) (camera.position.y - camera.viewportHeight / 2) / 55, 0), Loader.map[0].length - 1);
            int end_j = Math.max(Math.min((int) (camera.position.y + camera.viewportHeight / 2) / 55, Loader.map[0].length - 1), 0);
            for (int i = begin_i; i <= end_i; i++) {
                for (int j = begin_j; j <= end_j; j++) {
                    if (Loader.map[i][j] != null) Loader.map[i][j].draw(sb);
                }
            }
            for (Snowflake snowflake : Loader.snowflakes) {
                snowflake.draw(sb);
            }
            for (Ring ring : Loader.rings) {
                ring.draw(sb);
            }
            Loader.exit.draw(sb);
            ball.draw(sb);
            left.draw(sb);
            right.draw(sb);
            up.draw(sb);
            pause.draw(sb);
            life.draw(sb, camera);
            X.draw(sb, camera);
            sb.draw(numbers.get(Loader.numberOfLives), camera.position.x - camera.viewportWidth / 2 + 182, camera.position.y - camera.viewportHeight / 2 + 440, 30, 35);
            for (int i = 0; i < Loader.numberOfRings; i++) {
                sb.draw(ring, camera.position.x - camera.viewportWidth / 2 + 230 + i * 18, camera.position.y - camera.viewportHeight / 2 + 446, 15, 30);
            }
            String points = String.valueOf(Loader.numberOfPoints);
            for (int i = 0; i < points.length(); i++) {
                sb.draw(numbers.get(Integer.parseInt(String.valueOf(points.charAt(points.length() - i - 1)))), camera.position.x - camera.viewportWidth / 2 + 885 - i * 31, camera.position.y - camera.viewportHeight / 2 + 440, 30, 35);
            }
        } else {
            background.draw(sb, camera);
            resume.draw(sb);
            again.draw(sb);
            menu.draw(sb);
        }
        sb.end();
    }

    @Override
    public void dispose() {
        ball.dispose();
        left.dispose();
        right.dispose();
        up.dispose();
        pause.dispose();
        life.dispose();
        X.dispose();
        ring.dispose();
        for (int i = 0; i < numbers.size(); i++) {
            numbers.get(i).dispose();
        }
        resume.dispose();
        again.dispose();
        menu.dispose();
        background.dispose();
    }
}
