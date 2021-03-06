/*
 * Copyright The OpenTelemetry Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.opentelemetry.javaagent.typed.client;

import io.opentelemetry.context.propagation.TextMapPropagator;
import io.opentelemetry.javaagent.typed.client.http.HttpClientTypedTracer;
import io.opentelemetry.trace.Span;

public class SampleHttpClientTypedTracer
    extends HttpClientTypedTracer<SampleHttpClientTypedSpan, String, String> {
  @Override
  protected String getInstrumentationName() {
    return "test";
  }

  @Override
  protected String getVersion() {
    return "test";
  }

  @Override
  protected String getSpanName(String o) {
    return "test-span";
  }

  @Override
  protected TextMapPropagator.Setter<String> getSetter() {
    return new TextMapPropagator.Setter<String>() {
      @Override
      public void set(String carrier, String key, String value) {}
    };
  }

  @Override
  protected SampleHttpClientTypedSpan wrapSpan(Span span) {
    return new SampleHttpClientTypedSpan(span);
  }
}
