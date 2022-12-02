package ddm.nana.monitoramentohortaifsp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

// Orientações:
/*
- página principal da biblioteca:
https://github.com/PhilJay/MPAndroidChart

- video aula deste exemplo (tem várias outras):
https://www.youtube.com/watch?v=yrbgN2UvKGQ

- Configurar ambiente:

    - mudar a visualização de Android para Project (igual fazemos pra
configurar o firebase)

    - no arquivo settings.gradle, colocar em
dependencyresolutionmanagement o maven{url https jitpack...}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        [..]
        --> maven { url "https://jitpack.io" }
    }
}
    - salvar, syncronizar o projeto (sync) (igual faz na configuracao
do firebase)

    - no arquivo build.gradle que esta dentro de app, colocar em
dependencies ...philjay...

dependencies {

    implementation 'androidx.appcompat:appcompat:1.5.1'
    implementation 'com.google.android.material:material:1.7.0'
    implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
    testImplementation 'junit:junit:4.13.2'
    androidTestImplementation 'androidx.test.ext:junit:1.1.4'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.5.0'

    [...]
    // FirebaseUI for Firebase Realtime Database
    --> implementation 'com.firebaseui:firebase-ui-database:8.0.1'
    // FirebaseUI for Firebase Auth
    --> implementation 'com.firebaseui:firebase-ui-auth:8.0.1'
    --> implementation 'com.github.PhilJay:MPAndroidChart:v3.1.0'
}
    - e em plugins adicionar:
    //Firebase
    --> id 'com.google.gms.google-services'

    - salvar, syncronizar

    - no arquivo do build.gradle fora do app adicionar em plugins
    //Firebase
    --> id 'com.google.gms.google-services' version '4.3.0' apply false

    - salvar, syncronizar


- no xml da tela, um objeto grafico de linha, amarrado em todos os
cantos, ocupando toda a tela:

<com.github.mikephil.charting.charts.LineChart
    android:id="@+id/linechart"
    android:layout_width="0dp"
    android:layout_height="0dp"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />

 */
public class MainActivity extends AppCompatActivity {

    // Referência do grafico
    LineChart grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grafico = findViewById(R.id.grafico);

        // Array dos dados que irão formar as linhas
        LineDataSet lineDataSet1 = new LineDataSet(preencherDadosUmidade(),"Umidade");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);

        // Coloca os dados no gráfico
        LineData data = new LineData(dataSets);
        grafico.setData(data);
        grafico.invalidate();
    }

    private ArrayList<Entry> preencherDadosUmidade() {

        // Entry é uma classe da propria biblioteca

        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, 20));
        dataVals.add(new Entry(1, 24));
        dataVals.add(new Entry(2, 2));
        dataVals.add(new Entry(3, 10));
        return dataVals;
    }
}