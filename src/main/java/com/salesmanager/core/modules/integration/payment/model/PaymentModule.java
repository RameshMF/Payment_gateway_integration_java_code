package com.salesmanager.core.modules.integration.payment.model;

import java.math.BigDecimal;

import java.util.List;

import com.salesmanager.core.customer.Customer;
import com.salesmanager.core.exception.IntegrationException;
import com.salesmanager.core.order.Order;
import com.salesmanager.core.payments.Payment;
import com.salesmanager.core.payments.Transaction;
import com.salesmanager.core.shoppingcart.ShoppingCartItem;
import com.salesmanager.core.system.IntegrationConfiguration;
import com.salesmanager.core.system.IntegrationModule;
import com.salesmanager.shop.MerchantStore;

public interface PaymentModule {
	
	public void validateModuleConfiguration(IntegrationConfiguration integrationConfiguration, MerchantStore store) throws IntegrationException;
	
	/**
	 * Returns token-value related to the initialization of the transaction This
	 * method is invoked for paypal express checkout
	 * @param customer
	 * @param order
	 * @return
	 * @throws IntegrationException
	 */
	public Transaction initTransaction(
			MerchantStore store, Customer customer, BigDecimal amount, Payment payment, IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException;
	
	public Transaction authorize(
			MerchantStore store, Customer customer, List<ShoppingCartItem> items, BigDecimal amount, Payment payment, IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException;

	
	public Transaction capture(
			MerchantStore store, Customer customer, Order order, Transaction capturableTransaction, IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException;
	
	public Transaction authorizeAndCapture(
			MerchantStore store, Customer customer, List<ShoppingCartItem> items, BigDecimal amount, Payment payment, IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException;
	
	public Transaction refund(
			boolean partial, MerchantStore store, Transaction transaction, Order order, BigDecimal amount, IntegrationConfiguration configuration, IntegrationModule module)
			throws IntegrationException;

}
