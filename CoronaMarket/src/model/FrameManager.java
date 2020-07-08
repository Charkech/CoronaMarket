package model;
import view.CashierPage;
import view.SalesProfitLoss;
import view.StorekeeperPage;
import model.SalesProfitLossModel;
import controller.OrdersViewController;
import controller.OrdersViewControllerStorekeeper;
import controller.PriceUpdateRequestsController;
import controller.RefundsForDamangedSupplyController;
import controller.RequestPriceUpdateController;
import controller.RequestToAddNewProductController;
import controller.SalesProfitLossController;
import controller.StorekeeperPageController;
import model.SupplyViewModel;
import controller.SupplyViewController;
import controller.SupplyViewControllerCashier;
import controller.SupplyViewControllerStorekeeper;
import view.SupplyView;
import view.SupplyViewCashier;
import view.SupplyViewStorekeeper;
import view.LogInView;
import controller.CashierPageController;
import controller.LogInController;
import model.ManagerPageModel;
import view.ManagerPage;
import view.NewProductsRequests;
import controller.ManagerPageController;
import controller.NewProductsRequestsController;
import view.OrdersView;
import view.OrdersViewStorekeeper;
import view.PriceUpdateRequests;
import view.RefundsForDamagedSupply;
import view.RequestPriceUpdate;
import view.RequestToAddNewProduct;
import model.OrdersViewModel;
import controller.OrdersViewController;
public class FrameManager {
	private boolean manager;
	private boolean cashier;
	private boolean storekeeper;
	private static FrameManager framemanager_instance=null;
	private FrameManager() {};
	public static FrameManager getInstance() {
		if(framemanager_instance==null)
			framemanager_instance=new FrameManager();
		return framemanager_instance;
	}
	public void setManager(boolean isManager) {
		this.manager=isManager;
	}
	public void setCashier(boolean isCashier) {
		this.cashier=isCashier;
	}
	public void setStorekeeper(boolean isStorekeeper) {
		this.storekeeper=isStorekeeper;
	}
	public void MoveToLoginPage() {
		LogInView view = new LogInView();
		LogInModel model = new LogInModel();
		LogInController controller= new LogInController(view,model);
		view.setVisible(true);
	}
	public void MoveToCashierPage() {
		CashierPage view = new CashierPage();
		CashierPageModel model = new CashierPageModel();
		CashierPageController controller=new CashierPageController(view,model);
		view.setVisible(true);
	}
	public void MoveToSupplyView() {
		SupplyView view=new SupplyView();
		SupplyViewModel model=new SupplyViewModel();
		SupplyViewController controller=new SupplyViewController(view,model);
		view.setVisible(true);
	}
	public void MoveToSupplyViewStorekeeper() {
		SupplyViewStorekeeper view=new SupplyViewStorekeeper();
		SupplyViewModelStorekeeper model=new SupplyViewModelStorekeeper();
		SupplyViewControllerStorekeeper controller=new SupplyViewControllerStorekeeper(view,model);
		view.setVisible(true);
	}
	public void MoveToStoreKeeperPage() {
	StorekeeperPage view = new StorekeeperPage();
		StorekeeperPageModel model = new StorekeeperPageModel();
		StorekeeperPageController controller=new StorekeeperPageController(view,model);
		view.setVisible(true);
	}
	public void MoveToManagerPage() {
		ManagerPage view = new ManagerPage();
		ManagerPageModel model = new ManagerPageModel();
		ManagerPageController controller=new ManagerPageController(view,model);
		view.setVisible(true);
	}
	public void MoveToSalesProfitLoss() {
		SalesProfitLoss view=new SalesProfitLoss();
		SalesProfitLossModel model=new SalesProfitLossModel();
		SalesProfitLossController controller=new SalesProfitLossController(view,model);
		view.setVisible(true);
	}
	public void MoveToOrdersPage() {
		OrdersView view=new OrdersView();
		OrdersViewModel model=new OrdersViewModel();
		OrdersViewController controller=new OrdersViewController(view,model);
		view.setVisible(true);
	}
	public void MoveToRefundsPage() {
		RefundsForDamagedSupply view=new RefundsForDamagedSupply();
		RefundsForDamagedSupplyModel model=new RefundsForDamagedSupplyModel();
		RefundsForDamangedSupplyController controller=new RefundsForDamangedSupplyController(view,model);
		view.setVisible(true);
	}
	public void MovePriceUpdateRequests() {
		PriceUpdateRequests view=new PriceUpdateRequests();
		PriceUpdateRequestsModel model=new PriceUpdateRequestsModel();
		PriceUpdateRequestsController controller=new PriceUpdateRequestsController(view,model);
		view.setVisible(true);
	}
	public void MoveRequestToAddNewItem() {
		RequestToAddNewProduct view = new RequestToAddNewProduct();
		RequestToAddNewProductModel model = new RequestToAddNewProductModel();
		RequestToAddNewProductController controller=new RequestToAddNewProductController(view,model);
		view.setVisible(true);
	}
	public void MoveToNewProductsRequests() {
		NewProductsRequests view=new NewProductsRequests();
		NewProductsRequestsModel model=new NewProductsRequestsModel();
		NewProductsRequestsController controller=new NewProductsRequestsController(view,model);
		view.setVisible(true);
	}
	public void MoveToRequestPriceUpdate() {
		RequestPriceUpdate view=new RequestPriceUpdate();
		RequestPriceUpdateModel model=new RequestPriceUpdateModel();
		RequestPriceUpdateController controller=new RequestPriceUpdateController(view,model);
		view.setVisible(true);
	}
	public void MoveToSupplyViewCashier() {
		SupplyViewCashier view = new SupplyViewCashier();
		SupplyViewModelCashier model=new SupplyViewModelCashier();
		SupplyViewControllerCashier controller = new SupplyViewControllerCashier(view,model);
		view.setVisible(true);
	}
	public void MoveToOrdersViewStorekeeper() {
		OrdersViewStorekeeper view=new OrdersViewStorekeeper();
		OrdersViewModelStorekeeper model=new OrdersViewModelStorekeeper();
		OrdersViewControllerStorekeeper controller = new OrdersViewControllerStorekeeper(view,model);
		view.setVisible(true);
	}
}
