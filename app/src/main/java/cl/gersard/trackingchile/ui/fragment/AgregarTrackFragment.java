package cl.gersard.trackingchile.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cl.gersard.trackingchile.R;
import cl.gersard.trackingchile.domain.Registro;
import cl.gersard.trackingchile.domain.Track;
import cl.gersard.trackingchile.repository.ApiConstants;
import cl.gersard.trackingchile.repository.FuncionesRest;
import cl.gersard.trackingchile.util.RunnableArgs;
import io.realm.Realm;

/**
 * A simple {@link Fragment} subclass.
 */
public class AgregarTrackFragment extends Fragment {


    @BindView(R.id.edit_codigo_agregar_fragment)
    EditText mEditCodigo;
    @BindView(R.id.edit_descripcion_agregar_fragment)
    EditText mEditDescripcion;
    Unbinder unbinder;

    public AgregarTrackFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance() {
        return new AgregarTrackFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_agregar_track, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_buscar_agregar_fragment)
    public void onViewClicked() {
        RunnableArgs runnableArgs = new RunnableArgs() {
            @Override
            public void run() {
                if (this.getResponse() == ApiConstants.RESPONSE_OK) {
                    //TODO ENVIAR AL DETALLE FRAGMENT
                    Toast.makeText(getContext(), "LA LLAMA ESTUVO OK", Toast.LENGTH_SHORT).show();
                    //TODO OPTION JSON CON GSON, RECIBES ELA CLASE TRACK Y LA PASAS A JSON, LUEGO CREAS EL BUNDLE Y LO PONES COM PUT STRNIG, LUEGO CUANDO CAMBIAS DE FRAGMENT, LE PASAS EL ARGUMENTO
                    //TODO EN L OTRO FRAGMENTO, TOMARIAS EL STRING Y CON GSON LO TRANSFORMAR A LA CLASE TRACK
                    Realm realm = Realm.getDefaultInstance();
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            Track track = getTrack();
                            track.setIdTrack();
                            track.setCodigoSeguimiento(mEditCodigo.getText().toString().trim());
                            track.setDescripcion(mEditDescripcion.getText().toString());
                            for (Registro registro : track.getRegistros()) {
                                registro.setIdRegistro();
                            }
                            if (track.getDatosgenerales() != null){
                                track.getDatosgenerales().setIdDatosGenerales();
                            }
                            realm.copyToRealm(track);
                        }
                    });

                } else {
                    //TODO MOSTRAR MENSAJE DE ERROR
                    Toast.makeText(getContext(), "LA LLAMA FALLO", Toast.LENGTH_SHORT).show();
                }
            }
        };


        FuncionesRest.consultarSeguimiento(mEditCodigo.getText().toString().trim(), runnableArgs);
    }


}
