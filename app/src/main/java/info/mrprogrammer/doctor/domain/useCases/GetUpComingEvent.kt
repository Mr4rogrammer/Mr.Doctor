/**
 * Created by Krishna Kumar Eswaran on 2024/09/07.
 */

package info.mrprogrammer.doctor.domain.useCases

import info.mrprogrammer.doctor.domain.repository.MainScreenRepository
import info.mrprogrammer.doctor.ui.composable.card.DoctorInfoCardModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetUpComingEvent @Inject constructor(
    private val mainScreenRepository: MainScreenRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend operator fun invoke(): DoctorInfoCardModel {
        return withContext(dispatcher) {
            return@withContext mainScreenRepository.getUpComingEvent()
        }
    }
}