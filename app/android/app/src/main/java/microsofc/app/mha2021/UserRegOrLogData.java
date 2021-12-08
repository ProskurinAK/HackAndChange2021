package microsofc.app.mha2021;

import androidx.annotation.Nullable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserRegOrLogData {

    @SerializedName("username")
    @Expose
    private String name;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("password")
    @Expose
    private String password;

    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("token")
    @Expose
    private String token;

    @SerializedName("message")
    @Expose
    private String message;

    public UserRegOrLogData(@Nullable String name, @Nullable String password, @Nullable String email,
                            @Nullable String id, @Nullable String token, @Nullable String message) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.id = id;
        this.token = token;
        this.message = message;
    }

    @Override
    public String toString(){
        String formedString = new String("name:"+ name + "password:" + password);
        if(email!=null) {
            formedString = formedString + "email:" + email;
        }
        return formedString;
    }

    public String getName(){ return name; }
    public  String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getId(){
        return id;
    }
    public String getToken(){
        return token;
    }
    public String getMessage(){return  message;}
}
