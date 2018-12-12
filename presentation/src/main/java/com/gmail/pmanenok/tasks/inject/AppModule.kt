package com.gmail.pmanenok.tasks.inject

import android.content.Context
import com.gmail.pmanenok.data.db.AppDataBase
import com.gmail.pmanenok.data.db.dao.StudentDao
import com.gmail.pmanenok.data.net.RestService
import com.gmail.pmanenok.data.repositories.StudentRepositoryImplTestDb
import com.gmail.pmanenok.domain.executor.PostExecutorThread
import com.gmail.pmanenok.domain.repositories.StudentRepository
import com.gmail.pmanenok.tasks.app.App
import com.gmail.pmanenok.tasks.executor.UIThread
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule() {
    //(val context: Context) {
    //@Singleton
    @Provides
    fun provideContext(app: App): Context = app.applicationContext// = this.context

    @Provides
    fun providePostExecutorThread(): PostExecutorThread = UIThread()

/*
    @Provides
    fun provideStudentRepository(restService: RestService, studentDao: StudentDao): StudentRepository =
        StudentRepositoryImplTestDb(restService, studentDao)

    @Provides
    fun provideStudentDao(appDataBase: AppDataBase): StudentDao = appDataBase.getStudentDao()
*/

    /*@Provides
    fun provideAppDataBase(context: Context): AppDataBase = AppDataBase.getInstance(context)

    @Provides
    fun provideRestService(@Named(URL_INJECT_NAME_DEBUG) url: String): RestService =
        RestService("https://api.backendless.com/3C38FF89-D6CA-F09A-FF2D-375419F6C600/6D5A1710-032A-8000-FF13-60CA35177F00/data/")

    @Provides
    @Named(URL_INJECT_NAME_DEBUG)
    fun provideServerUrlDebug(): String =
        "https://api.backendless.com/3C38FF89-D6CA-F09A-FF2D-375419F6C600/6D5A1710-032A-8000-FF13-60CA35177F00/data/"

    @Provides
    @Named(URL_INJECT_NAME_RELEASE)
    fun provideServerUrlRelease(): String =
        "https://api.backendless.com/3C38FF89-D6CA-F09A-FF2D-375419F6C600/6D5A1710-032A-8000-FF13-60CA35177F00/data/"
*/

}