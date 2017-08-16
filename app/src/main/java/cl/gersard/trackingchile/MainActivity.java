package cl.gersard.trackingchile;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cl.gersard.trackingchile.domain.Track;
import cl.gersard.trackingchile.repository.ApiConstants;
import cl.gersard.trackingchile.repository.FuncionesRest;
import cl.gersard.trackingchile.ui.fragment.TrackingListFragment;
import cl.gersard.trackingchile.util.RunnableArgs;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_codigo_search)
    EditText mEditCodigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//
//




        //asigno el fragmento
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.main_container, new TrackingListFragment()).commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.img_btn_search)
    public void onViewClicked() {


        RunnableArgs runnableArgs = new RunnableArgs() {
            @Override
            public void run() {
                if (this.getResponse() == ApiConstants.RESPONSE_OK) {
                    //TODO ENVIAR AL DETALLE FRAGMENT
                    Toast.makeText(MainActivity.this, "LA LLAMA ESTUVO OK", Toast.LENGTH_SHORT).show();
                    //TODO OPTION JSON CON GSON, RECIBES ELA CLASE TRACK Y LA PASAS A JSON, LUEGO CREAS EL BUNDLE Y LO PONES COM PUT STRNIG, LUEGO CUANDO CAMBIAS DE FRAGMENT, LE PASAS EL ARGUMENTO
                    //TODO EN L OTRO FRAGMENTO, TOMARIAS EL STRING Y CON GSON LO TRANSFORMAR A LA CLASE TRACK
                    //TODO OPTION REALM, TOMAS EL ID, Y LO PASAS COMO ARGUMENTO, EN EL OTRO FRAGMENTO TOAMS EL ID Y HACSE UNA QUERY PARA VBUSCAR EL TRACK CON ESE ID

                } else {
                    //TODO MOSTRAR MENSAJE DE ERROR
                    Toast.makeText(MainActivity.this, "LA LLAMA FALLO", Toast.LENGTH_SHORT).show();
                }
            }
        };



        FuncionesRest.consultarSeguimiento(mEditCodigo.getText().toString().trim(), runnableArgs);
    }
}
