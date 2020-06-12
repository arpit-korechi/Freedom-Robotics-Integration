package com.example.freedomroboticsintegration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private String responseString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new GetData().execute();

    }


    public class GetData extends AsyncTask<Void, Void, Void> {

        private static final String TAG = "Response";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {

            OkHttpClient client = new OkHttpClient();

//            URLS
//            1 http://pratikbutani.x10.mx/json_data.json
//            2 http://api.androidhive.info/json/movies.json
//            3 https://api.freedomrobotics.ai/accounts/AF9111FB06CD795D636B8E2AA/devices/D8252D3D5B65C5E1CE9A1C7A684/?mc_token=T6e1428e1e4499aa7f7146cf6&mc_secret=Sfccd4c788405f188bed3be27

            Request request = new Request.Builder()
                    .url("https://api.freedomrobotics.ai/accounts/AF9111FB06CD795D636B8E2AA/devices/D81448E13B2FDCBE27FB03CD6DE/commands?platforms=[%22ros%22]")
                    .addHeader("mc_token", "T8a49691affa89e85193ea2c3")
                    .addHeader("mc_secret", "Sf221daf4e0c9faf01facf9b7")
                    .build();

            Response response = null;

            try {

                response = client.newCall(request).execute();
                responseString = response.body().string();

            } catch (Exception e) {

                Log.e(TAG, "doInBackground: Error"+e );
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            TextView response = (TextView) findViewById(R.id.response);
            response.setText(responseString);

          /*  try {
                JSONObject main = new JSONObject(responseString);

                main.optString("fr.fleet.name");
                JSONArray frDeviceKeyTopic = main.getJSONArray("fr.device.key_topics");

                main.optString("compute_architecture");
                JSONObject frOperatorStopCommand = main.getJSONObject("fr.operator.stop_command");

                JSONObject data = frOperatorStopCommand.getJSONObject("data");
                data.optString("topic");
                data.optString("platform");

                JSONObject message = data.getJSONObject("message");
                message.optString("data");
                data.optString("expiration_secs");
                data.optString("type");

//                fr.operator.stop_command END block

                JSONObject mcRemoteControl = main.getJSONObject("mc.remote_control");

                mcRemoteControl.optString("robot_height");
                mcRemoteControl.optString("path_min_distance");
                mcRemoteControl.optString("robot_width");
                mcRemoteControl.optString("relocate_theta_variance");
                mcRemoteControl.optString("topic");
                mcRemoteControl.optString("rotate_lidar");
                mcRemoteControl.optString("odometry_realignment_topic");
                mcRemoteControl.optString("robot_length");
                mcRemoteControl.optString("way_point_topic");
                mcRemoteControl.optString("base_frame");
                mcRemoteControl.optString("gps_way_point_topic");
                mcRemoteControl.optString("relocate_x_variance");
                mcRemoteControl.optString("gps_topic");
                mcRemoteControl.optString("max_fps");
                mcRemoteControl.optString("linear_velocity");
                mcRemoteControl.optString("max_bandwidth");

                JSONArray maps = mcRemoteControl.getJSONArray("maps");

                mcRemoteControl.optString("pose_injection_frame");
                mcRemoteControl.optString("max_video_resolution");
                mcRemoteControl.optString("angular_velocity");
                mcRemoteControl.optString("relocate_y_variance");
                mcRemoteControl.optString("draw_axis");
                mcRemoteControl.optString("path_topic");
                mcRemoteControl.optString("topic_type");
                mcRemoteControl.optString("video_mouse_interactions_topic");
                mcRemoteControl.optString("map_topic");
                mcRemoteControl.optString("max_bandwidth");
                mcRemoteControl.optString("max_bandwidth");
                mcRemoteControl.optString("max_bandwidth");
                mcRemoteControl.optString("max_bandwidth");

                JSONObject transformations = mcRemoteControl.getJSONObject("transformations");
                transformations.optBoolean("showAxis");
                transformations.optString("name");
                transformations.optBoolean("showLinks");
                transformations.optBoolean("length");
                transformations.optBoolean("showNames");
                transformations.optBoolean("lineWidth");

                mcRemoteControl.optString("lidar_topic");
                mcRemoteControl.optBoolean("colorize_map");
                mcRemoteControl.optBoolean("strafe_button");
                mcRemoteControl.optString("robot_shape");

//                mc.remote_control object END

                main.optString("fr.agent.interface");
                main.optBoolean("fr.agent.webrtc_enabled");
                main.optString("fr.agent.version");

                JSONObject frPilotLastUser = main.getJSONObject("fr.pilot.last_user");


                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");
                main.optString("fr.agent.interface");

            } catch (JSONException e) {
                e.printStackTrace();
            }*/

            Log.i(TAG, "onPostExecute: " + responseString);
        }

    }



}