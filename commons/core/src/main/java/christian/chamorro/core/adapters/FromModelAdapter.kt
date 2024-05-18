package christian.chamorro.core.adapters

interface FromModelAdapter<Model, Data> {
    fun fromModel(model: Model): Data

    fun fromModeList(models: List<Model>): List<Data> {
        return models.map { fromModel(it) }
    }
}
