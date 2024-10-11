package c.anurag.network;

public interface IEntry<JsonModel> {
    /**
     * A method used to convert the json network model to view model used by view.
     *
     * @param jsonModel
     *         network json model
     *
     * @return view model used by view.
     */
    JsonModel insertUpdate(JsonModel jsonModel);
}
