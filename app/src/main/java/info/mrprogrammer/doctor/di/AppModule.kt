package info.mrprogrammer.doctor.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import info.mrprogrammer.doctor.data.repository.MainScreenRepositoryImpl
import info.mrprogrammer.doctor.domain.repository.MainScreenRepository
import info.mrprogrammer.doctor.domain.useCases.GetBottomBarMenu
import info.mrprogrammer.doctor.domain.useCases.GetMenu
import info.mrprogrammer.doctor.domain.useCases.GetNearByDoctor
import info.mrprogrammer.doctor.domain.useCases.GetUpComingEvent

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun provideBottomBarRepository(): MainScreenRepository {
        return MainScreenRepositoryImpl()
    }

    @Provides
    fun provideGetBottomBarMenu(mainScreenRepository: MainScreenRepository): GetBottomBarMenu {
        return GetBottomBarMenu(mainScreenRepository)
    }


    @Provides
    fun provideGetUpComingEvent(mainScreenRepository: MainScreenRepository): GetUpComingEvent {
        return GetUpComingEvent(mainScreenRepository)
    }

    @Provides
    fun provideGetMenu(mainScreenRepository: MainScreenRepository): GetMenu {
        return GetMenu(mainScreenRepository)
    }

    @Provides
    fun provideGetNearByDoctor(mainScreenRepository: MainScreenRepository): GetNearByDoctor {
        return GetNearByDoctor(mainScreenRepository)
    }
}