//
//  PasswordEvaluator.h
//  Spend1
//
//  Created by Jaehwan Park on 2/28/15.
//  Copyright (c) 2015 Jaehwan Park. All rights reserved.
//

@import Foundation;
@import Darwin.Availability;

/**
 
 */
typedef NS_ENUM(NSUInteger, NJOPasswordStrength) {
    NJOVeryWeakPasswordStrength,
    NJOWeakPasswordStrength,
    NJOReasonablePasswordStrength,
    NJOStrongPasswordStrength,
    NJOVeryStrongPasswordStrength,
};

/**
 
 */
@interface NJOPasswordStrengthEvaluator : NSObject

/**
 
 */
+ (NJOPasswordStrength)strengthOfPassword:(NSString *)password;

/**
 
 */
+ (NSString *)localizedStringForPasswordStrength:(NJOPasswordStrength)strength;

@end

#pragma mark -

/**
 
 */
@interface NJOPasswordValidator : NSObject

/**
 
 */
+ (instancetype)standardValidator;

/**
 
 */
+ (instancetype)validatorWithRules:(NSArray *)rules;

/**
 
 */
- (BOOL)validatePassword:(NSString *)password
            failingRules:(out NSArray * __autoreleasing *)rules;
@end

#pragma mark -

/**
 
 */
@protocol NJOPasswordRule <NSObject>

/**
 
 */
- (BOOL)evaluateWithString:(NSString *)string;

/**
 
 */
- (NSString *)localizedErrorDescription;

@end

#pragma mark -

/**
 
 */
@interface NJOAllowedCharacterRule : NSObject <NJOPasswordRule>

/**
 
 */
+ (instancetype)ruleWithAllowedCharacters:(NSCharacterSet *)characterSet;

@end

/**
 
 */
@interface NJORequiredCharacterRule : NSObject <NJOPasswordRule>

/**
 
 */
+ (instancetype)ruleWithRequiredCharacters:(NSCharacterSet *)characterSet;

///

/**
 
 */
+ (instancetype)lowercaseCharacterRequiredRule;

/**
 
 */
+ (instancetype)uppercaseCharacterRequiredRule;

/**
 
 */
+ (instancetype)decimalDigitCharacterRequiredRule;

/**
 
 */
+ (instancetype)symbolCharacterRequiredRule;

@end

#pragma mark -

/**
 
 */
@interface NJODictionaryWordRule : NSObject <NJOPasswordRule>

/**
 
 */
+ (instancetype)rule;

@end

#pragma mark -

/**
 
 */
@interface NJOLengthRule : NSObject <NJOPasswordRule>

/**
 
 */
+ (instancetype)ruleWithRange:(NSRange)range;

@end

#pragma mark -

/**
 
 */
@interface NJOPredicateRule : NSObject <NJOPasswordRule>

+ (instancetype)ruleWithPredicate:(NSPredicate *)predicate;

@end

#pragma mark -

/**
 
 */
@interface NJORegularExpressionRule : NSObject <NJOPasswordRule>

+ (instancetype)ruleWithRegularExpression:(NSRegularExpression *)regularExpression;

@end

#pragma mark -

/**
 */
@interface NJOBlockRule : NSObject <NJOPasswordRule>

+ (instancetype)ruleWithBlock:(BOOL (^)(NSString *password))block;

@end

///

/**
 
 */
extern CGFloat NJOEntropyForString(NSString *string);
