package com.google.code.struts2.scope.conversation;

import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

import com.google.code.struts2.scope.conversation.ConversationConfig;
import com.google.code.struts2.scope.conversation.ConversationConfigBuilder;
import com.google.code.struts2.scope.conversation.ConversationConstants;
import com.google.code.struts2.scope.testutil.ScopeTestCase;
import com.google.code.struts2.test.junit.StrutsConfiguration;
import com.opensymphony.xwork2.inject.Inject;

@StrutsConfiguration(locations = "struts.xml")
public class ConversationConfigBuilderImplTest extends ScopeTestCase<Object> {
	
	@Inject(value=ConversationConstants.CONFIG_BUILDER_KEY)
	ConversationConfigBuilder builder;
	
	@Test
	public void testGetConversationConfig() {
		
		Map<String, ConversationConfig> configs = builder.getConversationConfigs();
		assertNotNull(configs);
		//TODO
	}
	
	@Test
	public void testConversationNaming() throws Exception {
		
		Map<String, ConversationConfig> configs = builder.getConversationConfigs();
		assertNotNull(configs);
		//TODO
	}

}
