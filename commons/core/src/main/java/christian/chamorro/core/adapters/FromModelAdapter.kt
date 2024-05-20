package christian.chamorro.core.adapters

/**
 * Interface to provide an adapter structure to map model to data.
 */
interface FromModelAdapter<Model, Data> {

    /**
     * Function to map a single model to single data.
     */
    fun fromModel(model: Model): Data

    /**
     * Function to map a model list to data list.
     */
    fun fromModeList(models: List<Model>): List<Data> {
        return models.map { fromModel(it) }
    }
}
