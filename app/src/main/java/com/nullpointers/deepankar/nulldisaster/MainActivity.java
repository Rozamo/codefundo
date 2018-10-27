package com.nullpointers.deepankar.nulldisaster;

import com.microsoft.windowsazure.mobileservices.table.MobileServiceTable;
import com.microsoft.windowsazure.mobileservices.table.TableOperationCallback;
import com.nullpointers.deepankar.nulldisaster.TodoItem;
import com.microsoft.windowsazure.mobileservices.*;
import com.microsoft.windowsazure.mobileservices.http.ServiceFilterResponse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {

    private MobileServiceClient mClient;
    private MobileServiceTable<TodoItem> mToDoTable;
    private MobileServiceTable<Users> mUserTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            mClient = new MobileServiceClient(
                    "https://nulldisaster.azurewebsites.net",
                    this
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        final TodoItem item = new TodoItem("1","Awesome item");
        final Users user = new Users("deepankar","d@gmail.com","d@gmail.com",87);
        mClient.getTable(Users.class).insert(user, new TableOperationCallback<Users>() {
            public void onCompleted(Users entity, Exception exception, ServiceFilterResponse response) {
                if (exception == null) {
                    // Insert succeeded
                } else {
                    // Insert failed
                }
            }
        });

    }

}
