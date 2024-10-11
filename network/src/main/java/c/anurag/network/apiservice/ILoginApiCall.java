package c.anurag.network.apiservice;

import c.anurag.network.beans.location.LocationsResponse;
import c.anurag.network.beans.login.LoginResponse;
import c.anurag.network.beans.user.locationdepartments.UserLocationDepartmentsResponse;
import c.anurag.network.callback.IViewCallback;

/**
 * Created by anuragpurwar
 */

public abstract class ILoginApiCall {
    public abstract void getLogin(IViewCallback<LoginResponse> abstractViewCallback);

    public abstract void getLocation(IViewCallback<LocationsResponse> abstractViewCallback);

    public abstract void getUserLocationDepartment(IViewCallback<UserLocationDepartmentsResponse> abstractViewCallback);
}
