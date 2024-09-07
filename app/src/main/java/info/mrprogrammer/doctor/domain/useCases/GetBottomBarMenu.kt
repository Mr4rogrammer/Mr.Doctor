/**
 * Created by Krishna Kumar Eswaran on 2024/09/06.
 */

package info.mrprogrammer.doctor.domain.useCases

import info.mrprogrammer.doctor.ui.composable.bottombar.BottomBarModel
import info.mrprogrammer.doctor.domain.repository.MainScreenRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBottomBarMenu @Inject constructor(
    private val mainScreenRepository: MainScreenRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke(): List<BottomBarModel> {
        return withContext(dispatcher) {
            val result = mainScreenRepository.getListOfMenus()
            return@withContext result
        }
    }
}