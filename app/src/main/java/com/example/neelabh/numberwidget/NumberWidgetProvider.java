package com.example.neelabh.numberwidget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Random;

/**
 * Created by neelabh on 01-05-2018.
 */

public class NumberWidgetProvider extends AppWidgetProvider {
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds){
           final int N=appWidgetIds.length;

        for(int i=0; i<N; i++){
            int appWidgetId = appWidgetIds[i];

            int number = new Random().nextInt(100);

            Intent intent = new Intent(context,NumberWidgetProvider.class);
            intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
            intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, appWidgetIds);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

            RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.number_appwidget);
            remoteViews.setTextViewText(R.id.number,String.valueOf(number));
            remoteViews.setOnClickPendingIntent(R.id.number,pendingIntent);

            appWidgetManager.updateAppWidget(appWidgetId,remoteViews);
        }
    }
}
