package christian.chamorro.uicomponents.adapters

interface ToModelAdapter<Model, Data> {

    abstract fun toModel(data: Data): Model

    fun toModelList(data:List<Data>) : List<Model> {
        return data.map { toModel(it) }
    }
}