package christian.chamorro.core.adapters

interface ToModelAdapter<Model, Data> {
    fun toModel(data: Data): Model

    fun toModelList(data: List<Data>): List<Model> {
        return data.map { toModel(it) }
    }
}
