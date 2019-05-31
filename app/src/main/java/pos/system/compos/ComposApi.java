package pos.system.compos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import pos.system.compos.POJO.Category;

public interface ComposApi {

    @GET("/api/category/getAll")
    Call<List<Category>> getAllCategory();
}
