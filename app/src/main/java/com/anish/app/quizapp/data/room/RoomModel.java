package com.anish.app.quizapp.data.room;

import android.app.Application;

import androidx.room.Room;

import com.anish.app.quizapp.data.model.ListConverter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.internal.managers.ApplicationComponentManager;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModel {
    @Provides
    @Singleton
    public static AppDatabase provideDB(Application application) {
        return Room.databaseBuilder(application,
                        AppDatabase.class, "app_database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
//                .addTypeConverter(ListConverter.class)
                .build();
    }

    @Provides
    @Singleton
    public static QuestionDao provideUserDataDAO(AppDatabase appDatabase) {
        return appDatabase.questionDao();
    }
}
