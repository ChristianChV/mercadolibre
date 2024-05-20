package christian.chamorro.core.adapters

/**
 * Interface to provide an adapter structure to map data to model.
 */
interface ToModelAdapter<Model, Data> {
    /**
     * Function to map a single model to single data.
     */
    fun toModel(data: Data): Model

    /**
     * Function to map a model list to data list.
     */
    fun toModelList(data: List<Data>): List<Model> {
        return data.map { toModel(it) }
    }
}
